package org.ntutsmartmedicalcloud.schedulerbackend.service;

import org.ntutsmartmedicalcloud.schedulerbackend.dao.NonWorkTaskRepository;
import org.ntutsmartmedicalcloud.schedulerbackend.dao.TaskRepository;
import org.ntutsmartmedicalcloud.schedulerbackend.dao.WorkTaskRepository;
import org.ntutsmartmedicalcloud.schedulerbackend.dto.AstronautDto;
import org.ntutsmartmedicalcloud.schedulerbackend.dto.TaskDto;
import org.ntutsmartmedicalcloud.schedulerbackend.entity.NonWorkTask;
import org.ntutsmartmedicalcloud.schedulerbackend.entity.Task;
import org.ntutsmartmedicalcloud.schedulerbackend.entity.WorkTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private WorkTaskRepository workTaskRepository;

    @Autowired
    private NonWorkTaskRepository nonWorkTaskRepository;

    @Autowired
    private AstronautService astronautService;

    public List<TaskDto> getAllTasks() {
        return this.taskRepository
                .findAll()
                .stream()
                .map(this::taskToTaskDto)
                .collect(Collectors.toList());
    }

    public List<TaskDto> scheduleTasks() {
        AstronautDto astronautDto = astronautService.getAstronaut();
        List<WorkTask> workTasks = workTaskRepository.findAll();
        List<NonWorkTask> nonWorkTasks = nonWorkTaskRepository.findAll();
        LocalDateTime missionStartTime = astronautDto.getMissionStartTime();
        LocalDateTime missionEndTime = astronautDto.getMissionEndTime();
        if(!nonWorkTasks.isEmpty()) {
            NonWorkTask mealTask = nonWorkTasks
                    .stream()
                    .filter(task -> task.getMeal())
                    .collect(Collectors.toList())
                    .get(0);
            NonWorkTask sleepTask = nonWorkTasks
                    .stream()
                    .filter(task -> task.getSleep())
                    .collect(Collectors.toList())
                    .get(0);
            int jetlagDays = 1;
            LocalDateTime prevStartTime = missionStartTime;
            while(prevStartTime.isBefore(missionEndTime.minusHours(sleepTask.getIntervalInHours()))) {
                int interval = sleepTask.getIntervalInHours();
                if(jetlagDays <= astronautDto.getJetlagAdjustmentInDays()) {
                    interval = sleepTask.getIntervalInHours() + 1;
                }
                Task sleepingTask = new Task();
                sleepingTask.setTitle(sleepTask.getTitle());
                LocalDateTime sleepStartTime = prevStartTime.plusHours(interval);
                sleepingTask.setStartTime(sleepStartTime);
                LocalDateTime sleepEndTime = sleepStartTime.plusHours(sleepTask.getDuration());
                sleepingTask.setEndTime(sleepEndTime);
                sleepingTask.setWorkTask(false);
                taskRepository.save(sleepingTask);
                LocalDateTime dayStartTime = prevStartTime.plusHours(3);
                while(dayStartTime.isBefore(sleepStartTime)) {
                    Task eatingTask = new Task();
                    eatingTask.setTitle(mealTask.getTitle());
                    LocalDateTime mealStartTime = dayStartTime;
                    eatingTask.setStartTime(mealStartTime);
                    LocalDateTime mealEndTime = mealStartTime.plusHours(mealTask.getDuration());
                    eatingTask.setEndTime(mealEndTime);
                    eatingTask.setWorkTask(false);
                    taskRepository.save(eatingTask);
                    dayStartTime = eatingTask.getEndTime();
                }
                prevStartTime = sleepingTask.getEndTime();
            }
        }
        List<WorkTask> workTasksProcessed = workTasks
                .stream()
                .sorted(Comparator.comparing(WorkTask::getDifficulty).reversed())
                .collect(Collectors.toList());
        HashMap<LocalDateTime, Integer> emptySlots = new HashMap<>();
        List<Task> currentTasks = taskRepository.findAll();
        for(int i = 0; i < currentTasks.size()-1; i++) {
            Duration slotDuration = Duration.between(currentTasks.get(i).getEndTime(), currentTasks.get(i+1).getStartTime());
            int durationInMinutes  = (int)Math.abs(slotDuration.toMinutes());
            if(durationInMinutes != 0) {
                emptySlots.put(currentTasks.get(i).getEndTime(), durationInMinutes);
            }
        }
        Duration duration = Duration.between(currentTasks.get(currentTasks.size()-1).getEndTime(), missionEndTime);
        int durationInMinutes = (int)Math.abs(duration.toMinutes());
        if(durationInMinutes != 0) {
            emptySlots.put(currentTasks.get(currentTasks.size()-1).getEndTime(), durationInMinutes);
        }
        for(LocalDateTime slotStart: emptySlots.keySet()) {
            LocalDateTime nextStart = slotStart;
            int durationOfSlot = emptySlots.get(nextStart);
            for(WorkTask task: workTasksProcessed) {
                if(!task.getIncluded()) {
                    if(task.getDuration() * 60 <= durationOfSlot) {
                        Task workTask = new Task();
                        workTask.setTitle(task.getTitle());
                        workTask.setStartTime(nextStart);
                        workTask.setEndTime(nextStart.plusMinutes(task.getDifficulty() * 60));
                        workTask.setWorkTask(true);
                        taskRepository.save(workTask);
                        task.setIncluded(true);
                        workTaskRepository.save(task);
                    }
                }
            }
        }
        return taskRepository
                .findAll()
                .stream()
                .map(this::taskToTaskDto)
                .collect(Collectors.toList());
    }

    public List<TaskDto> prolongTask(int id, int prolongedTimeInHours, boolean shortenNextTask) {
        Optional<Task> taskToProlong = taskRepository.findById(id);
        if(taskToProlong.isPresent() && taskToProlong.get().getEndTime().isAfter(LocalDateTime.now())) {
            Task task = taskToProlong.get();
            LocalDateTime originalEndTime = task.getEndTime();
            LocalDateTime newEndTime = originalEndTime.plusHours(prolongedTimeInHours);
            Optional<Task> nextTask = taskRepository.findByStartTime(originalEndTime);
            if(nextTask.isPresent()) {
                if(shortenNextTask) {
                    if(newEndTime.isBefore(nextTask.get().getEndTime())) {
                        nextTask.get().setStartTime(newEndTime);
                        taskRepository.save(nextTask.get());
                    } else {
                        return null;
                    }
                } else {
                    while(nextTask.isPresent()) {
                        Optional<Task> nextNextTask = taskRepository.findByStartTime(nextTask.get().getEndTime());
                        nextTask.get().setStartTime(nextTask.get().getStartTime().plusHours(prolongedTimeInHours));
                        nextTask.get().setEndTime(nextTask.get().getEndTime().plusHours(prolongedTimeInHours));
                        taskRepository.save(nextTask.get());
                        nextTask = nextNextTask;
                    }
                }
            }
            task.setEndTime(newEndTime);
            taskRepository.save(task);
            return taskRepository
                    .findAll()
                    .stream()
                    .map(this::taskToTaskDto)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<TaskDto> shortenTask(int id, int shortenedTimeInHours, boolean prolongNextTask) {
        Optional<Task> taskToShorten = taskRepository.findById(id);
        if(taskToShorten.isPresent() && taskToShorten.get().getEndTime().isAfter(LocalDateTime.now())) {
            Task task = taskToShorten.get();
            LocalDateTime originalEndTime = task.getEndTime();
            LocalDateTime newEndTime = originalEndTime.minusHours(shortenedTimeInHours);
            if(newEndTime.isAfter(taskToShorten.get().getStartTime())) {
                Optional<Task> nextTask = taskRepository.findByStartTime(originalEndTime);
                if(nextTask.isPresent()) {
                    if(prolongNextTask) {
                        nextTask.get().setStartTime(newEndTime);
                        taskRepository.save(nextTask.get());
                    } else {
                        while(nextTask.isPresent()) {
                            Optional<Task> nextNextTask = taskRepository.findByStartTime(nextTask.get().getEndTime());
                            nextTask.get().setStartTime(nextTask.get().getStartTime().minusHours(shortenedTimeInHours));
                            nextTask.get().setEndTime(nextTask.get().getEndTime().minusHours(shortenedTimeInHours));
                            taskRepository.save(nextTask.get());
                            nextTask = nextNextTask;
                        }
                    }
                }
                task.setEndTime(newEndTime);
                taskRepository.save(task);
                return taskRepository
                        .findAll()
                        .stream()
                        .map(this::taskToTaskDto)
                        .collect(Collectors.toList());
            }
        }
        return null;
    }

    public boolean deleteAllTasks() {
        taskRepository.deleteAll();
        workTaskRepository.deleteAll();
        nonWorkTaskRepository.deleteAll();
        return true;
    }

    private TaskDto taskToTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setStartTime(task.getStartTime());
        taskDto.setEndTime(task.getEndTime());
        taskDto.setWorkTask(task.getWorkTask());
        return taskDto;
    }
}

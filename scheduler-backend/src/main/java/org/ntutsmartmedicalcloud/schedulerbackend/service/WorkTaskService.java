package org.ntutsmartmedicalcloud.schedulerbackend.service;

import org.ntutsmartmedicalcloud.schedulerbackend.dao.WorkTaskRepository;
import org.ntutsmartmedicalcloud.schedulerbackend.dto.WorkTaskDto;
import org.ntutsmartmedicalcloud.schedulerbackend.entity.WorkTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkTaskService {

    @Autowired
    private WorkTaskRepository workTaskRepository;

    public List<WorkTaskDto> getAllWorkTasks() {
        return this.workTaskRepository
                .findAll()
                .stream()
                .map(this::workTaskToWorkTaskDto)
                .collect(Collectors.toList());
    }

    public boolean addNewWorkTask(WorkTaskDto workTaskDto) {
        WorkTask workTask = new WorkTask();
        workTask.setPriority(workTaskDto.getPriority());
        workTask.setTitle(workTaskDto.getTitle());
        workTask.setDifficulty(workTaskDto.getDifficulty());
        workTask.setDifficulty(workTaskDto.getDifficulty());
        workTaskRepository.save(workTask);
        return true;
    }

    public boolean deleteWorkTask(int id) {
        Optional<WorkTask> workTask = workTaskRepository.findById(id);
        if(workTask.isPresent()) {
            workTaskRepository.delete(workTask.get());
            return true;
        }
        return false;
    }

    private WorkTaskDto workTaskToWorkTaskDto(WorkTask workTask) {
        WorkTaskDto workTaskDto = new WorkTaskDto();
        workTaskDto.setId(workTask.getId());
        workTaskDto.setPriority(workTask.getPriority());
        workTaskDto.setTitle(workTask.getTitle());
        workTaskDto.setDifficulty(workTask.getDifficulty());
        workTaskDto.setDuration(workTask.getDuration());
        return workTaskDto;
    }
}

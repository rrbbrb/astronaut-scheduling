package org.ntutsmartmedicalcloud.schedulerbackend.service;

import org.ntutsmartmedicalcloud.schedulerbackend.dao.NonWorkTaskRepository;
import org.ntutsmartmedicalcloud.schedulerbackend.dto.NonWorkTaskDto;
import org.ntutsmartmedicalcloud.schedulerbackend.entity.NonWorkTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NonWorkTaskService {

    @Autowired
    private NonWorkTaskRepository nonWorkTaskRepository;

    public List<NonWorkTaskDto> getAllNonWorkTasks() {
        return this.nonWorkTaskRepository
                .findAll()
                .stream()
                .map(this::nonWorkTaskToTaskDto)
                .collect(Collectors.toList());
    }

    public boolean addNewWorkTask(NonWorkTaskDto nonWorkTaskDto) {
        NonWorkTask nonWorkTask = new NonWorkTask();
        nonWorkTask.setTitle(nonWorkTaskDto.getTitle());
        nonWorkTask.setDuration(nonWorkTaskDto.getDuration());
        nonWorkTask.setIntervalInHours(nonWorkTaskDto.getIntervalInHours());
        nonWorkTask.setSleep(nonWorkTaskDto.getSleep());
        nonWorkTask.setMeal(nonWorkTaskDto.getMeal());
        nonWorkTaskRepository.save(nonWorkTask);
        return true;
    }

    public boolean deleteNonWorkTask(int id) {
        Optional<NonWorkTask> nonWorkTask = nonWorkTaskRepository.findById(id);
        if(nonWorkTask.isPresent()) {
            nonWorkTaskRepository.delete(nonWorkTask.get());
            return true;
        }
        return false;
    }

    private NonWorkTaskDto nonWorkTaskToTaskDto(NonWorkTask nonWorkTask) {
        NonWorkTaskDto nonWorkTaskDto = new NonWorkTaskDto();
        nonWorkTaskDto.setId(nonWorkTask.getId());
        nonWorkTaskDto.setTitle(nonWorkTask.getTitle());
        nonWorkTaskDto.setDuration(nonWorkTask.getDuration());
        nonWorkTaskDto.setIntervalInHours(nonWorkTask.getIntervalInHours());
        nonWorkTaskDto.setSleep(nonWorkTask.getSleep());
        nonWorkTaskDto.setMeal(nonWorkTask.getMeal());
        return nonWorkTaskDto;
    }
}

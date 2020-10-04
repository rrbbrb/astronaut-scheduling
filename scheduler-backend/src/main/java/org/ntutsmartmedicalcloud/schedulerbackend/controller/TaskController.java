package org.ntutsmartmedicalcloud.schedulerbackend.controller;

import org.ntutsmartmedicalcloud.schedulerbackend.dto.TaskDto;
import org.ntutsmartmedicalcloud.schedulerbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @PostMapping("/schedule")
    public ResponseEntity<List<TaskDto>> scheduleTasks() {
        return new ResponseEntity<>(taskService.scheduleTasks(), HttpStatus.OK);
    }

    @PutMapping("/prolong/{id}")
    public ResponseEntity<List<TaskDto>> prolongTask(@PathVariable @RequestBody Integer id,
                                                     @RequestBody Integer prolongedTimeInHour,
                                                     @RequestBody Boolean shortenNextTask) {
        List<TaskDto> taskDtos = taskService.prolongTask(id, prolongedTimeInHour, shortenNextTask);
        if(taskDtos != null) {
            return new ResponseEntity<>(taskDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/shorten/{id}")
    public ResponseEntity<List<TaskDto>> shortenTask(@PathVariable @RequestBody Integer id,
                                                     @RequestBody Integer shortenedTimeInHour,
                                                     @RequestBody Boolean prolongNextTask) {
        List<TaskDto> taskDtos = taskService.shortenTask(id, shortenedTimeInHour, prolongNextTask);
        if(taskDtos != null) {
            return new ResponseEntity<>(taskDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete-all")
    public ResponseEntity<Boolean> deleteAllTasks() {
        return new ResponseEntity<>(taskService.deleteAllTasks(), HttpStatus.OK);
    }
}

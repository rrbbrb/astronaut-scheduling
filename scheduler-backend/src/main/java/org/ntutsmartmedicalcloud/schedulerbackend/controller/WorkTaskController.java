package org.ntutsmartmedicalcloud.schedulerbackend.controller;

import org.ntutsmartmedicalcloud.schedulerbackend.dto.WorkTaskDto;
import org.ntutsmartmedicalcloud.schedulerbackend.service.WorkTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work-task")
public class WorkTaskController {

    @Autowired
    private WorkTaskService workTaskService;

    @GetMapping
    public ResponseEntity<List<WorkTaskDto>> getAllWorkTasks() {
        return new ResponseEntity<>(workTaskService.getAllWorkTasks(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Boolean> addNewWorkTask(@RequestBody WorkTaskDto workTaskDto) {
        return new ResponseEntity<>(workTaskService.addNewWorkTask(workTaskDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteWorkTask(@PathVariable @RequestBody Integer id) {
        if(workTaskService.deleteWorkTask(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

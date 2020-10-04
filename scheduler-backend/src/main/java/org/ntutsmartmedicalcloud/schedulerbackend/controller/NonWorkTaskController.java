package org.ntutsmartmedicalcloud.schedulerbackend.controller;

import org.ntutsmartmedicalcloud.schedulerbackend.dto.NonWorkTaskDto;
import org.ntutsmartmedicalcloud.schedulerbackend.service.NonWorkTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/non-work-task")
public class NonWorkTaskController {

    @Autowired
    private NonWorkTaskService nonWorkTaskService;

    @GetMapping
    public ResponseEntity<List<NonWorkTaskDto>> getAllNonWorkTasks() {
        return new ResponseEntity<>(nonWorkTaskService.getAllNonWorkTasks(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Boolean> addNewWorkTask(@RequestBody NonWorkTaskDto nonWorkTaskDto) {
        return new ResponseEntity<>(nonWorkTaskService.addNewWorkTask(nonWorkTaskDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteNonWorkTask(@PathVariable @RequestBody Integer id) {
        if(nonWorkTaskService.deleteNonWorkTask(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

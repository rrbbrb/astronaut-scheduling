package org.ntutsmartmedicalcloud.schedulerbackend.controller;

import org.ntutsmartmedicalcloud.schedulerbackend.dto.AstronautDto;
import org.ntutsmartmedicalcloud.schedulerbackend.service.AstronautService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/astronaut")
public class AstronautController {

    @Autowired
    private AstronautService astronautService;

    @GetMapping
    public ResponseEntity<AstronautDto> getAstronaut() {
        return new ResponseEntity<>(astronautService.getAstronaut(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> addNewAstronaut(@RequestBody AstronautDto astronautDto) {
        return new ResponseEntity<>(astronautService.addNewAstronaut(astronautDto), HttpStatus.OK);
    }
}

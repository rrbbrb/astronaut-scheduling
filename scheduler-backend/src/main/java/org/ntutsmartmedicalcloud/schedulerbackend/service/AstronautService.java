package org.ntutsmartmedicalcloud.schedulerbackend.service;

import org.ntutsmartmedicalcloud.schedulerbackend.dao.AstronautRepository;
import org.ntutsmartmedicalcloud.schedulerbackend.dto.AstronautDto;
import org.ntutsmartmedicalcloud.schedulerbackend.entity.Astronaut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AstronautService {

    @Autowired
    private AstronautRepository astronautRepository;

    public AstronautDto getAstronaut() {
        return astronautToAstronautDto(astronautRepository.findAll().get(0));
    }

    public boolean addNewAstronaut(AstronautDto astronautDto) {
        deleteAstronaut();
        Astronaut astronaut = new Astronaut();
        astronaut.setFullName(astronautDto.getFullName());
        astronaut.setAgeGroup(astronautDto.getAgeGroup());
        astronaut.setAmountOfSleepInHours(astronautDto.getAmountOfSleepInHours());
        astronaut.setJetlagAdjustmentInDays(astronautDto.getJetlagAdjustmentInDays());
        astronaut.setMissionStartTime(astronautDto.getMissionStartTime());
        astronaut.setMissionEndTime(astronautDto.getMissionEndTime());
        astronautRepository.save(astronaut);
        return true;
    }

    public AstronautDto astronautToAstronautDto(Astronaut astronaut) {
        AstronautDto astronautDto = new AstronautDto();
        astronautDto.setFullName(astronaut.getFullName());
        astronautDto.setAgeGroup(astronaut.getAgeGroup());
        astronautDto.setAmountOfSleepInHours(astronaut.getAmountOfSleepInHours());
        astronautDto.setJetlagAdjustmentInDays(astronaut.getJetlagAdjustmentInDays());
        astronautDto.setMissionStartTime(astronaut.getMissionStartTime());
        astronautDto.setMissionEndTime(astronaut.getMissionEndTime());
        return astronautDto;
    }

    public void deleteAstronaut() {
        astronautRepository.deleteAll();
    }

}

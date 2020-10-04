package org.ntutsmartmedicalcloud.schedulerbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class AstronautDto {
    private String fullName;
    private String ageGroup;
    private Double amountOfSleepInHours;
    private Integer jetlagAdjustmentInDays;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime missionStartTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime missionEndTime;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Double getAmountOfSleepInHours() {
        return amountOfSleepInHours;
    }

    public void setAmountOfSleepInHours(Double amountOfSleepInHours) {
        this.amountOfSleepInHours = amountOfSleepInHours;
    }

    public Integer getJetlagAdjustmentInDays() {
        return jetlagAdjustmentInDays;
    }

    public void setJetlagAdjustmentInDays(Integer jetlagAdjustmentInDays) {
        this.jetlagAdjustmentInDays = jetlagAdjustmentInDays;
    }

    public LocalDateTime getMissionStartTime() {
        return missionStartTime;
    }

    public void setMissionStartTime(LocalDateTime missionStartTime) {
        this.missionStartTime = missionStartTime;
    }

    public LocalDateTime getMissionEndTime() {
        return missionEndTime;
    }

    public void setMissionEndTime(LocalDateTime missionEndTime) {
        this.missionEndTime = missionEndTime;
    }
}

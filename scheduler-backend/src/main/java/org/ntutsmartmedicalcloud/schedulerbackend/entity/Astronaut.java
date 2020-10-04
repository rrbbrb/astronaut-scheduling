package org.ntutsmartmedicalcloud.schedulerbackend.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age_group")
    private String ageGroup;

    @Column(name = "amount_of_sleep_in_hours")
    private Double amountOfSleepInHours;

    @Column(name = "jetlag_adjustment_in_days")
    private Integer jetlagAdjustmentInDays;

    @Column(name = "mission_start_time")
    private LocalDateTime missionStartTime;

    @Column(name = "mission_end_time")
    private LocalDateTime missionEndTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

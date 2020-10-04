package org.ntutsmartmedicalcloud.schedulerbackend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class TaskDto {

    private Integer id;

    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime endTime;

    private boolean isWorkTask;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isWorkTask() {
        return isWorkTask;
    }

    public void setWorkTask(boolean workTask) {
        this.isWorkTask = workTask;
    }
}

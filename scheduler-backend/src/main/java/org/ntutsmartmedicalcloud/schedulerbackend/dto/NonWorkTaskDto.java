package org.ntutsmartmedicalcloud.schedulerbackend.dto;

public class NonWorkTaskDto {
    private Integer id;

    private String title;

    private Integer duration;

    private Integer intervalInHours;

    private Boolean isSleep;

    private Boolean isMeal;

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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getIntervalInHours() {
        return intervalInHours;
    }

    public void setIntervalInHours(Integer intervalInHours) {
        this.intervalInHours = intervalInHours;
    }

    public Boolean getSleep() {
        return isSleep;
    }

    public void setSleep(Boolean sleep) {
        isSleep = sleep;
    }

    public Boolean getMeal() {
        return isMeal;
    }

    public void setMeal(Boolean meal) {
        isMeal = meal;
    }
}

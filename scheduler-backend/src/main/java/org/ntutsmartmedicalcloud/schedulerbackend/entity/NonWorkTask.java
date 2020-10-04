package org.ntutsmartmedicalcloud.schedulerbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "non_work_tasks")
public class NonWorkTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "interval_in_hours")
    private Integer intervalInHours;

    @Column(name = "is_sleep")
    private Boolean isSleep;

    @Column(name = "is_meal")
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

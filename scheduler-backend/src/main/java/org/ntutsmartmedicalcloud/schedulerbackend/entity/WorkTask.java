package org.ntutsmartmedicalcloud.schedulerbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "work_tasks")
public class WorkTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "title")
    private String title;

    @Column(name = "difficulty")
    private Integer difficulty;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "included")
    private Boolean included;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getIncluded() {
        return included;
    }

    public void setIncluded(Boolean included) {
        this.included = included;
    }
}

package com.example.digital.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="batch")
public class Batch implements Serializable {

    public Batch(){
        super();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "batch_id", nullable = false, updatable = false)
    private Long batchId;

    @Column(name = "name")
    private String name;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="description")
    private String description;

    @ManyToMany(targetEntity = Learner.class, cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "batch_learner", joinColumns=@JoinColumn(name = "batch_id"),
            inverseJoinColumns = @JoinColumn(name = "learner_id"))
    private Set<Learner> learners;







    @JoinColumn(name="course_id")
    @ManyToOne( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Course course;


    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Learner> getLearners() {
        return learners;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setLearners(Set<Learner> learners) {
        this.learners = learners;
    }
}




package com.example.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import javax.persistence.Column;
import java.sql.Date;

public class LearnerCredentialResourceResponse {

    @JsonIgnoreProperties({"courses"})
    private Institution institution;
    @JsonIgnoreProperties({"institution","grades"})
    private Course course;
    private Grade grade;
    @JsonUnwrapped
    @JsonIgnoreProperties({"learnerCredential"})
    private LearnerCredentialResource learnerCredentialResource;
    private Integer startYear;
    private Integer endYear;
    private Float Marks;
    private Date issuedDate;
    private String credentialName;
    private Integer credentialYear;

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public LearnerCredentialResource getLearnerCredentialResource() {
        return learnerCredentialResource;
    }

    public void setLearnerCredentialResource(LearnerCredentialResource learnerCredentialResource) {
        this.learnerCredentialResource = learnerCredentialResource;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Float getMarks() {
        return Marks;
    }

    public void setMarks(Float marks) {
        Marks = marks;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getCredentialName() {
        return credentialName;
    }

    public void setCredentialName(String credentialName) {
        this.credentialName = credentialName;
    }

    public Integer getCredentialYear() {
        return credentialYear;
    }

    public void setCredentialYear(Integer credentialYear) {
        this.credentialYear = credentialYear;
    }
}


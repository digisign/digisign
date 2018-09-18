package com.example.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class LearnerCredentialResourceResponse {

    @JsonIgnoreProperties({"courses"})
    private Institution institution;
    @JsonIgnoreProperties({"institution","grades"})
    private Course course;
    private Grade grade;
    @JsonUnwrapped
    @JsonIgnoreProperties({"learnerCredential"})
    private LearnerCredentialResource learnerCredentialResource;
    @JsonUnwrapped
    @JsonIgnoreProperties({"learnerCredentialId","learner","credential","course"})
    private LearnerCredential learnerCredential;

    @JsonUnwrapped
    @JsonIgnoreProperties({"course","institution","credentialId"})
    private Credential credential;

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

    public LearnerCredential getLearnerCredential() {
        return learnerCredential;
    }

    public void setLearnerCredential(LearnerCredential learnerCredential) {
        this.learnerCredential = learnerCredential;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}


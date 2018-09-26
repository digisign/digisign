package com.example.digital.entity;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="error_table")
public class ErrorTable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="error_table_id")
    private Long errorTableId;
    @Column(name="Institution_Name")
    private String instituteName;
    @Column(name="stack_trace")
    private String stackTrace;
    @Column(name="error_message")
    private String errorMessage;
    @Column(name="mobile_number_1")
    private String mobileNumber1;
    @Column(name="mobile_number_2")
    private String mobileNumber2;
    @Column(name="email_id_1")
    private String emailId1;
    @Column(name="email_id_2")
    private String emailId2;
    @Column(name="job_type")
    private String jobType;

    public Long getErrorTableId() {
        return errorTableId;
    }

    public void setErrorTableId(Long errorTableId) {
        this.errorTableId = errorTableId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMobileNumber1() {
        return mobileNumber1;
    }

    public void setMobileNumber1(String mobileNumber1) {
        this.mobileNumber1 = mobileNumber1;
    }

    public String getMobileNumber2() {
        return mobileNumber2;
    }

    public void setMobileNumber2(String mobileNumber2) {
        this.mobileNumber2 = mobileNumber2;
    }

    public String getEmailId1() {
        return emailId1;
    }

    public void setEmailId1(String emailId1) {
        this.emailId1 = emailId1;
    }

    public String getEmailId2() {
        return emailId2;
    }

    public void setEmailId2(String emailId2) {
        this.emailId2 = emailId2;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
}

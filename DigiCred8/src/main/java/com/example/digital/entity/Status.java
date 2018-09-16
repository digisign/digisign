package com.example.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "status")
public class Status implements Serializable {


    public Status() {
        super();
    }
    @Id
    @Column(name="status_id",insertable=false,updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long statusId;
    @Column(name="status_name")
    private String statusName;
    @Column(name="status_desc")
    private String statusDesc;


    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}

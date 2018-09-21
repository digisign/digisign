package com.example.digital.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "marks_type")
public class MarksType implements Serializable {

    public MarksType(){
        super();
    }
    @Id
    @Column(name="marks_type_id",insertable=false,updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long marksTypeId;

    @Column(name="type_desc")
    private String type;




    public Long getMarksTypeId() {
        return marksTypeId;
    }

    public void setMarksTypeId(Long marksTypeId) {
        this.marksTypeId = marksTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

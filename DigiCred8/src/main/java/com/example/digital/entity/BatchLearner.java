package com.example.digital.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@SuppressWarnings("serial")
@Embeddable
public class BatchLearner implements Serializable {

  /*  @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "batch_learner_id", nullable = false, updatable = false)
    private Long batchLearnerId;*/


    public BatchLearner() {
        super();
    }

    @Column(name="learner_id")
    private Long learnerId;

    @Column(name="batch_id")
    private Long batchId;


    public Long getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(Long learnerId) {
        this.learnerId = learnerId;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }
}

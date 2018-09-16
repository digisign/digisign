package com.example.digital.service;

import com.example.digital.entity.Learner;
import com.example.digital.entity.LearnerCredential;

import java.util.List;

public interface LearnerCredentialService {
    List<LearnerCredential> getLearnerCredentialsByLearner(Learner learner);
}

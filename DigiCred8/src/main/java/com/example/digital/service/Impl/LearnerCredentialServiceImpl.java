package com.example.digital.service.Impl;

import com.example.digital.entity.Learner;
import com.example.digital.entity.LearnerCredential;
import com.example.digital.repository.LearnerCredentialRepository;
import com.example.digital.service.LearnerCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerCredentialServiceImpl implements LearnerCredentialService {


    @Autowired
    private LearnerCredentialRepository learnerCredentialRepository;

    public List<LearnerCredential> getLearnerCredentialsByLearner(Learner learner){
       return  learnerCredentialRepository.findByLearner(learner);
    }

}

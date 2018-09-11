package com.example.digital.service.Impl;

import com.example.digital.entity.Learner;
import com.example.digital.repository.LearnerRepository;
import com.example.digital.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearnerServiceImpl implements LearnerService {


    @Autowired
    private LearnerRepository learnerRepository;
   public  Learner save(Learner learner){
       return learnerRepository.save(learner);
    }

}

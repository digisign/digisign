package com.example.digital.service.Impl;

import com.example.digital.common.ErrorMessages;
import com.example.digital.entity.Learner;
import com.example.digital.entity.User;
import com.example.digital.exception.DigiSignException;
import com.example.digital.repository.LearnerRepository;
import com.example.digital.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LearnerServiceImpl implements LearnerService {


    @Autowired
    private LearnerRepository learnerRepository;
   public  Learner save(Learner learner){
       return learnerRepository.save(learner);
    }


    public Learner getLearnerByUser(User user) {
        Optional<Learner> learner = learnerRepository.findByUser(user);
        if (!learner.isPresent()) {
            throw new DigiSignException(ErrorMessages.LEARNER_NOT_AVAILABLE.getReasonPhrase(), ErrorMessages.LEARNER_NOT_AVAILABLE.getCode());
        } else {
          return learner.get();
        }

    }


}

package com.example.digital.service;

import com.example.digital.entity.User;
import com.example.digital.entity.UserRecovery;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

     void sendMail(UserRecovery userRecovery) throws Exception;

}

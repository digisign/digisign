package com.example.digital.service;

import com.example.digital.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    public void sendMail(User user) throws Exception;

}

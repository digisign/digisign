package com.example.digital.service;

import com.example.digital.entity.UserRecovery;
import org.springframework.stereotype.Service;

@Service
public interface UserRecoveryService {
    UserRecovery getByToken(String token);
    UserRecovery updateUser(String token);
}

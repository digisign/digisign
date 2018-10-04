package com.example.digital.service.Impl;

import com.example.digital.common.ErrorMessages;
import com.example.digital.entity.UserRecovery;
import com.example.digital.exception.DigiSignException;
import com.example.digital.repository.UserRecoveryRepository;
import com.example.digital.service.UserRecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRecoveryServiceImpl implements UserRecoveryService {

    @Autowired
    private UserRecoveryRepository userRecoveryRepository;

    public  UserRecovery getByToken(String token){
        Optional<UserRecovery> recoveryOptional=userRecoveryRepository.findByToken(token);
        if(recoveryOptional.isPresent()){
            return recoveryOptional.get();
        }else{
            throw new DigiSignException(ErrorMessages.TOKEN_DOES_NOT_EXIST.getReasonPhrase(),ErrorMessages.TOKEN_DOES_NOT_EXIST.getCode());
        }
    }


    public UserRecovery updateUser(String token){
        UserRecovery userRecovery=getByToken(token);
        userRecovery.setValidated(true);
        userRecovery.getUser().setEmailVerified(true);
        return userRecoveryRepository.save(userRecovery);
    }
}

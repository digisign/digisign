package com.example.digital.service.Impl;

import com.example.digital.config.CredentialEncryptionConfig;
import com.example.digital.entity.Mail;
import com.example.digital.entity.User;
import com.example.digital.entity.UserRecovery;
import com.example.digital.service.EmailService;
import com.example.digital.util.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${DIGISIGN_TEAM_EMAIL}")
    private String DIGISIGN_TEAM_EMAIL;

    @Value("${baseUrl}")
    private String baseUrl;

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private CredentialEncryptionConfig credentialEncryptionConfig;

    public void sendMail(UserRecovery userRecovery) throws Exception{
        Mail mail=new Mail();
        mail.setMailTo(DIGISIGN_TEAM_EMAIL);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("username", userRecovery.getUser().getUserName());
        String relativeUrl= baseUrl +"token/"+userRecovery.getToken();
        model.put("link",relativeUrl);
        mail.setModel(model);
        emailSender.sendEmail(mail);
    }

}

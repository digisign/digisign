package com.example.digital.service.Impl;

import com.example.digital.entity.Mail;
import com.example.digital.entity.User;
import com.example.digital.service.EmailService;
import com.example.digital.util.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

public class EmailServiceImpl implements EmailService {

    @Value("${DIGISIGN_TEAM_EMAIL}")
    private String DIGISIGN_TEAM_EMAIL;

    @Autowired
    private EmailSender emailSender;

    public void sendMail(User user) throws Exception{
        Mail mail=new Mail();
        mail.setMailTo(DIGISIGN_TEAM_EMAIL);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("mailtype","unsubscribe");
        emailSender.sendEmail(mail);
    }

}

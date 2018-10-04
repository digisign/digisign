package com.example.digital.util;

import com.example.digital.entity.Mail;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.Map;


@Component
public class EmailSender {

    @Value("${MAIL_FROM}")
    private String MAIL_FROM;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    VelocityEngine velocityEngine;


    public void sendEmail(Mail mail) throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject("dummy subject");
            mimeMessageHelper.setFrom("expressgo@triconinfotech.com");
            mimeMessageHelper.setTo(mail.getMailTo());
            mail.setMailContent(geContentFromInternalTemplate(mail.getModel()));
            mimeMessageHelper.setText(mail.getMailContent(), true);
            mailSender.send(mimeMessageHelper.getMimeMessage());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }


    public String geContentFromInternalTemplate (Map< String, Object > model){
        StringBuffer content = new StringBuffer();
        try {
            content.append(
                    VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/templates/email-template-request-for-approval.vm", model));
        } catch (Exception e) {
        }
        return content.toString();
    }

}


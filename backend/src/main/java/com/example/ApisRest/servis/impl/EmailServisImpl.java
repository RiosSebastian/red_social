package com.example.ApisRest.servis.impl;

import com.example.ApisRest.servis.EmailServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EmailServisImpl  implements EmailServis {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String[] toUser, String subject, String massege) {
        SimpleMailMessage mailMassage = new SimpleMailMessage();

        mailMassage.setFrom("");//el correo desde donde sale el email.
        mailMassage.setTo(toUser);
        mailMassage.setSubject(subject);
        mailMassage.setText(massege);

        javaMailSender.send(mailMassage);
    }

    @Override
    public void sendEmailWithFile(String[] toUser, String subject, String massege, File file) {

    }
}

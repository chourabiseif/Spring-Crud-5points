package com.fivepoints.demo.services;

import com.fivepoints.demo.playLoad.requests.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
    @Autowired
    JavaMailSender javaMailSender;

    /* public void sendEmail(String to, String body , String topic ){
         System.out.println("Sending mail...");
         SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
         simpleMailMessage.setFrom("chourabiseif94@gmail.com");
         simpleMailMessage.setTo(to);
         simpleMailMessage.setText(body);
         simpleMailMessage.setSubject(topic);
         javaMailSender.send(simpleMailMessage);
         System.out.println("mail sent");
     }*/
    public String sendEmail(EmailRequest email) {
        System.out.println("Sending mail...");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("chourabiseif94@gmail.com");
        simpleMailMessage.setTo(email.getTo());
        simpleMailMessage.setText(email.getBody());
        simpleMailMessage.setSubject(email.getTopic());
        javaMailSender.send(simpleMailMessage);
        System.out.println("mail sent");
        return "Email sent successfully";
    }
}

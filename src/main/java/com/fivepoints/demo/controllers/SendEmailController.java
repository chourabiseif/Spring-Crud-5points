package com.fivepoints.demo.controllers;

import com.fivepoints.demo.playLoad.requests.EmailRequest;
import com.fivepoints.demo.playLoad.responses.ResponseMessage;
import com.fivepoints.demo.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailController {
    @Autowired
    SendEmailService sendEmailService;

    @RequestMapping(value = "/email/", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> sendEmail(@RequestBody EmailRequest email){
       String message = sendEmailService.sendEmail(email);
       return new ResponseEntity<>(new ResponseMessage(message), HttpStatus.OK);

    }

}

package com.fivepoints.demo.controllers;

import com.fivepoints.demo.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthentificationController {
    @Autowired
    AuthentificationService authentificationService;

    //login
    @RequestMapping (value = "/login/", method = RequestMethod.POST)
    private String Login(){
        return this.authentificationService.login();
    }
    //register
    @RequestMapping(value = "/register/", method = RequestMethod.POST)
    private String register(){
        return this.authentificationService.register();
    }

}

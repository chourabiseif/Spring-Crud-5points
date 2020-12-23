package com.fivepoints.demo.services;

import com.fivepoints.demo.models.About;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {

    //Login
    public String login(){

        return "Logged in successfully";

    }
    // register
    public String register(){
        return "register works";
    }
}

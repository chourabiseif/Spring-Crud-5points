package com.fivepoints.demo.controllers;

import com.fivepoints.demo.exceptions.EmailAlreadyUsedException;
import com.fivepoints.demo.exceptions.ResourceNotFoundException;
import com.fivepoints.demo.playLoad.requests.RegisterRequest;
import com.fivepoints.demo.playLoad.responses.ResponseMessage;
import com.fivepoints.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthControllers {
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ResponseMessage> register(@Valid @RequestBody RegisterRequest registerRequest) throws EmailAlreadyUsedException, ResourceNotFoundException {
        String message = this.authService.register(registerRequest);
        return ResponseEntity.ok(new ResponseMessage(message));
    }
}

package com.fivepoints.demo.controllers;

import com.fivepoints.demo.models.User;
import com.fivepoints.demo.playLoad.responses.ResponseMessage;
import com.fivepoints.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersControllers {
    //injection de dépendence pour que ce class utilise les méthodes d'un autre class
    @Autowired
    UserService userService;

    // creer nouveau user
    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> createUser(@RequestBody User user){

        String message =  this.userService.addUSer(user);
        return new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.OK);
    }

    // récuperer tous les users
    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers(){

        List<User> listUsers= this.userService.getUSers();
        return new ResponseEntity<>(listUsers, HttpStatus.OK);

    }

    // récupérer un user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByID(@PathVariable(value="id") Long id){

        User user =  this.userService.getUSer(id) ;
        return new ResponseEntity<>(user , HttpStatus.OK);
    }

    // updating a user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseMessage> updateUser( @PathVariable(value = "id") Long id, @RequestBody User user){
        String message =  this.userService.modifUser(id, user) ;
        return new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.OK);

    }

    // deleting a user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseMessage> deleteUser(@PathVariable(value="id") Long id){

       String message =  this.userService.effacerUser(id) ;
        return new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.OK);
    }

    // finding user with email
    @RequestMapping(value="/users/email/{email}" , method = RequestMethod.GET)
    public  ResponseEntity<User> getUserByEmail(@PathVariable(value="email") String email){
        User user =  this.userService.findByEMail(email);
        return new ResponseEntity<>(user , HttpStatus.OK);
    }
    // search user with first and last name
    @RequestMapping(value="/users/name/{firstname}/{lastname}" , method = RequestMethod.GET)
    public ResponseEntity<List<User>>  getUserByName(@PathVariable(value="firstname") String firstname , @PathVariable(value="lastname") String lastname){
        List<User> userList = this.userService.getUserByName(firstname,lastname);
        return new  ResponseEntity<>(userList , HttpStatus.OK);

    }
}

package com.fivepoints.demo.controllers;

import com.fivepoints.demo.models.User;
import com.fivepoints.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersControllers {
    //injection de dépendence pour que ce class utilise les méthodes d'un autre class
    @Autowired
    UserService userService;

    // récuperer tous les users
    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public List<User> getUsers(){
       return this.userService.getUSers() ;
    }

    // récupérer un user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserByID(@PathVariable(value="id") Long id){
        return this.userService.getUSer(id) ;
}
    // creer nouveau user
    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public String createUser(@RequestBody User user){
        return this.userService.addUSer(user);
    }
    // updating a user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public String updateUser( @PathVariable(value = "id") Long id, @RequestBody User user){
        return this.userService.modifUser(id, user) ;
    }

    // deleting a user
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value="id") Long id){
         this.userService.effacerUser(id) ;
    }

    // finding user with email
    @RequestMapping(value="/users/email/{email}" , method = RequestMethod.GET)
    public  User getUserByEmail(@PathVariable(value="email") String email){
        return this.userService.findByEMail(email);
    }
    // search user with first and last name
    @RequestMapping(value="/users/name/{firstname}/{lastname}" , method = RequestMethod.GET)
    public  List<User> getUserByName(@PathVariable(value="firstname") String firstname , @PathVariable(value="lastname") String lastname){
        return this.userService.getUserByName(firstname,lastname);
    }
}

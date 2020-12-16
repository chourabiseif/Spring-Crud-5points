package com.fivepoints.demo.services;

import com.fivepoints.demo.models.User;
import com.fivepoints.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUSer(User user){
        this.userRepository.save(user);
        return "user added";

    }
    //get all users
    public List<User> getUSers(){

        return this.userRepository.findAll();
    }
    //get one user by his id
    public User getUSer(Long id){
        return this.userRepository.findById(id).get();
    }

    //Modification

   public String modifUser(Long id, User user){
        User userfound = this.userRepository.findById(id).get();
        userfound.setEmail(user.getEmail());
        userfound.setFirstName(user.getFirstName());
        userfound.setLastName(user.getLastName());
        userfound.setPassword(user.getPassword());

        this.userRepository.save(userfound);
        return "modifié";
}
    // Suppression user
    public void effacerUser(Long id){
        this.userRepository.deleteById(id);

    }

}

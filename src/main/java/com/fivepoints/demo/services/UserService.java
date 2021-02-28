package com.fivepoints.demo.services;

import com.fivepoints.demo.exceptions.ResourceNotFoundException;
import com.fivepoints.demo.models.About;
import com.fivepoints.demo.models.Publication;
import com.fivepoints.demo.models.Role;
import com.fivepoints.demo.models.User;
import com.fivepoints.demo.repositories.AboutRepository;
import com.fivepoints.demo.repositories.PublicationRepository;
import com.fivepoints.demo.repositories.RoleRepository;
import com.fivepoints.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.KeyStore;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AboutRepository aboutRepository;
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    // adding user
    public String addUSer(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        return "user added";
    }
    //get all users
    public List<User> getUSers(){

        return this.userRepository.findAll();
    }
    //get one user by his id
    public User getUSer(Long id) throws ResourceNotFoundException {
        Optional<User> user = this.userRepository.findById(id);
        // Return statement if user exist or throw exception
        return user.orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    //Modification

   public String modifUser(Long id, User user) throws ResourceNotFoundException {
        Optional<User> userData = this.userRepository.findById(id);
       if (userData.isPresent()) {
           User userfound = userData.orElseThrow(() -> new ResourceNotFoundException("User not found"));
           userfound.setEmail(user.getEmail());
           userfound.setFirstName(user.getFirstName());
           userfound.setLastName(user.getLastName());
           // Change password if exist
           if(!user.getPassword().isEmpty())
           {
               userfound.setPassword(passwordEncoder.encode(user.getPassword()));
           }
           this.userRepository.save(userfound);
           return "user modified";
       }else {
           throw new ResourceNotFoundException("User not found");
       }

   }
    // Suppression user
    public String effacerUser(Long id) throws ResourceNotFoundException {
        Optional<User> userData = this.userRepository.findById(id);
        if (userData.isPresent()) {
            this.userRepository.deleteById(id);
            return "User deleted successfully!";
        } else {
            throw new ResourceNotFoundException("User not found");
        }
     }


    // search user with email
    public User findByEMail(String email){
        User user = null;
        try {
            user = userRepository.findByEmail(email);
        } catch (Exception e) {
            throw e;
        }
        return user;
    }
    // search user with last and first name
    public List<User> getUserByName(String firstname , String lastname){
        return  this.userRepository.searchUser(firstname,lastname);
    }


    // affect about to user
    public String affectAboutToUser(Long userId,int aboutId) throws ResourceNotFoundException {
        Optional<User> userData =  this.userRepository.findById(userId);
       if(userData.isPresent()){
           User userExisting = userData.orElseThrow(()->new ResourceNotFoundException("user not found"));
           Optional<About> aboutData = this.aboutRepository.findById(aboutId);
           if(aboutData.isPresent()){
               About aboutExisting = aboutData.orElseThrow(()->new ResourceNotFoundException("user not found"));
               userExisting.setAbout(aboutExisting);
               aboutExisting.setUser(userExisting);
               //save
               this.userRepository.save(userExisting);
               this.aboutRepository.save(aboutExisting);

           }
       }
        return "about affected to user";
    }

    // affect publication to user
    public String affectPublicationToUser(Long userId,int publicationId) throws ResourceNotFoundException {
        Optional<User> userData = this.userRepository.findById(userId);
        if(userData.isPresent()){
            User userExisting = userData.orElseThrow(()->new ResourceNotFoundException("user not found"));
            Optional<Publication> publicationData = this.publicationRepository.findById(publicationId);
            if(publicationData.isPresent()){
                //affecting user to publication
                Publication publicationExisting = publicationData.orElseThrow(()->new ResourceNotFoundException("publication not found"));
                publicationExisting.setUser(userExisting);
                //saving
                this.publicationRepository.save(publicationExisting);
                //affecting publication to userlist of publications
                List<Publication> userExistingPublications = userExisting.getPublications();
                userExistingPublications.add(publicationExisting);
                userExisting.setPublications(userExistingPublications);

                //saving

                this.userRepository.save(userExisting);

            }
        }
        return "publication affected to user";
    }

    // affect role to user
    public String affectRoleToUser(Long userId, int roleId) throws ResourceNotFoundException {
        Optional<User> userData = this.userRepository.findById(userId);
        if(userData.isPresent()){
            User userExisting =  userData.orElseThrow(()-> new ResourceNotFoundException("User not found"));
            Optional<Role> roleData = this.roleRepository.findById(roleId);
            if(roleData.isPresent()){
                Role existingRole = roleData.orElseThrow(() -> new ResourceNotFoundException("Role not found"));
                // adding role to user list of roles and saving it
                Set<Role> userListRoles = userExisting.getRoles();
                userListRoles.add(existingRole);
                userExisting.setRoles(userListRoles);
                userRepository.save(userExisting);

            }
        }
        return "role affected to user";

    }


}

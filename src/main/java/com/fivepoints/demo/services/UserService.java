package com.fivepoints.demo.services;

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
import org.springframework.stereotype.Service;

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
        return "user modified";
}
    // Suppression user
    public String effacerUser(Long id){
        this.userRepository.deleteById(id);
        return "user deleted";
     }
    // search user with email
    public User findByEMail(String email){
        return this.userRepository.findByEmail(email);
    }
    // search user with last and first name
    public List<User> getUserByName(String firstname , String lastname){
        return  this.userRepository.searchUser(firstname,lastname);
    }
    // affect about to user
    public String affectAboutToUser(Long userId,int aboutId){
       User user =  this.userRepository.findById(userId).get();
       About about = this.aboutRepository.findById(aboutId).get();
       user.setAbout(about);
//       about.setUser(user);
       this.userRepository.save(user);
//       this.aboutRepository.save(about);
       return "about affected to user";
    }
    // affect publication to user
    public String affectPublicationToUser(Long userId,int publicationId){
        User user =  this.userRepository.findById(userId).get();
        Publication publication = this.publicationRepository.findById(publicationId).get();

//        List<Publication> userPublicationList = user.getPublications();
//        // add publication to user publications list
//        userPublicationList.add(publication);
//        user.setPublications(userPublicationList);
//        this.userRepository.save(user);


        // add user to publication
        publication.setUser(user);
        this.publicationRepository.save(publication);

        return "publication affected to user";
    }
    // affect role to user
    public String affectRoleToUser(Long userId, int roleId){
       User user =  this.userRepository.findById(userId).get();
       Role role = this.roleRepository.findById(roleId).get();
        // adding role to user list of roles and saving it
        Set<Role> userListRoles = user.getRoles();
        userListRoles.add(role);
        user.setRoles(userListRoles);
        userRepository.save(user);

        // adding user to role list of users and saving it
        Set<User> roleListUsers = role.getUsers();
        roleListUsers.add(user);
        role.setUsers(roleListUsers);
        roleRepository.save(role);

       return "role affected to user";

    }


}

package com.fivepoints.demo.services;


import com.fivepoints.demo.exceptions.EmailAlreadyUsedException;
import com.fivepoints.demo.exceptions.ResourceNotFoundException;
import com.fivepoints.demo.models.ERole;
import com.fivepoints.demo.models.Role;
import com.fivepoints.demo.models.User;
import com.fivepoints.demo.playLoad.requests.RegisterRequest;
import com.fivepoints.demo.repositories.RoleRepository;
import com.fivepoints.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    // pour crypter le password (NB: il faut ajouter le bean BCryptPasswordEncoder dans l'application)
   @Autowired
   PasswordEncoder passwordEncoder;


    public String register(RegisterRequest registerRequest) throws EmailAlreadyUsedException,ResourceNotFoundException {
        // test if email already used
        if (this.userRepository.existsByEmail(registerRequest.getEmail())) {
            throw new EmailAlreadyUsedException("Error: Email is already in use!");
        }
        // Create new user account
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        // Traitement des Roles
        Set<String> registerRequestRoles = registerRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        // find Roles
        if (registerRequestRoles == null) {
            Role guestRole = this.roleRepository.findByName(ERole.GUEST)
                    .orElseThrow(() -> new ResourceNotFoundException("Error: Role is not found."));
            roles.add(guestRole);
        }else {
            registerRequestRoles.forEach(role -> {
                switch (role) {
                    case "super-admin":
                        Role superAdminRole = null;
                        try {
                            superAdminRole = this.roleRepository.findByName(ERole.SUPER_ADMIN)
                                    .orElseThrow(() -> new ResourceNotFoundException("Error: Role is not found."));
                        } catch (ResourceNotFoundException e) {
                            e.printStackTrace();
                        }
                        roles.add(superAdminRole);

                        break;
                    case "admin":
                        Role adminRole = null;
                        try {
                            adminRole = this.roleRepository.findByName(ERole.ADMIN)
                                    .orElseThrow(() -> new ResourceNotFoundException("Error: Role is not found."));
                        } catch (ResourceNotFoundException e) {
                            e.printStackTrace();
                        }
                        roles.add(adminRole);
                        break;
                    case "user":
                        Role userRole = null;
                        try {
                            userRole = this.roleRepository.findByName(ERole.USER)
                                    .orElseThrow(() -> new ResourceNotFoundException("Error: Role is not found."));
                        } catch (ResourceNotFoundException e) {
                            e.printStackTrace();
                        }
                        roles.add(userRole);
                        break;
                    default:
                        Role guestRole = null;
                        try {
                            guestRole = this.roleRepository.findByName(ERole.GUEST).orElseThrow(() -> new ResourceNotFoundException("Error: Role is not found."));
                        } catch (ResourceNotFoundException e) {
                            e.printStackTrace();
                        }
                        roles.add(guestRole);
                }
            });
        }
        // Affect User Roles
        user.setRoles(roles);
        this.userRepository.save(user);
        return "User registered successfully!";
    }









}

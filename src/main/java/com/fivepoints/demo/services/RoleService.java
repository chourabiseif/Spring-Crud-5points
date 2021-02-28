package com.fivepoints.demo.services;

import com.fivepoints.demo.exceptions.ResourceNotFoundException;
import com.fivepoints.demo.models.Role;
import com.fivepoints.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    // adding a role
    public String addRole(Role role){
        this.roleRepository.save(role);
        return "role added";
    }

    //Getting all roles
    public List<Role> getAllRoles(){
        return this.roleRepository.findAll();
    }

    //Get one role
    public Role getRoleByID(int id) throws ResourceNotFoundException {
        Optional<Role> role = this.roleRepository.findById(id);
        return role.orElseThrow(()-> new ResourceNotFoundException("Role Not found"));
    }

   //Modify role
    public String modifRole(int id ,Role role) throws ResourceNotFoundException {
        Optional<Role> roleData = this.roleRepository.findById(id);
        if(roleData.isPresent()){
            Role roleFound = roleData.orElse(null);
            roleFound.setName(role.getName());
            this.roleRepository.save(roleFound);
            return "Role Modified";
        }
        else{
            throw  new ResourceNotFoundException("Role not found");
        }

    }

    // Delete role
    public  String deleteRole(int id) throws ResourceNotFoundException {
        Optional<Role> role = this.roleRepository.findById(id);
        if(role.isPresent()){
            this.roleRepository.deleteById(id);
            return "Role deleted";
        }
        else{
            throw new ResourceNotFoundException("Role not found");
        }

    }

}

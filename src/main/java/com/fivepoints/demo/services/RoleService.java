package com.fivepoints.demo.services;

import com.fivepoints.demo.models.Role;
import com.fivepoints.demo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Role getRoleByID(int id){
        return this.roleRepository.findById(id).get();
   }

   //Modify role
    public String modifRole(int id ,Role role){
        Role roleFound = this.roleRepository.findById(id).get();
        roleFound.setName(role.getName());
        this.roleRepository.save(roleFound);
        return "Role Modified";
    }

    // Delete role
    public  String deleteRole(int id){
        this.roleRepository.deleteById(id);
        return "Role deleted";
    }

}

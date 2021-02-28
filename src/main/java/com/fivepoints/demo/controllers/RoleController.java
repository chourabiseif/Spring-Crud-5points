package com.fivepoints.demo.controllers;

import com.fivepoints.demo.exceptions.ResourceNotFoundException;
import com.fivepoints.demo.models.About;
import com.fivepoints.demo.models.Role;
import com.fivepoints.demo.playLoad.responses.ResponseMessage;
import com.fivepoints.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    //add Role
    @RequestMapping(value = "/roles/", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> addRole(@RequestBody Role role){
        String message =  this.roleService.addRole(role);
        return  new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.CREATED);
    }

    // getting all roles
    @RequestMapping(value = "/roles/", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> getAllRoles(){

        List<Role> rolesList = this.roleService.getAllRoles();
        return  new ResponseEntity<>(rolesList, HttpStatus.OK);
    }

    //getting one role by id
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.GET)
    public ResponseEntity<Role> getRoleByID(@PathVariable(value="id") int id) throws ResourceNotFoundException {

        Role role = this.roleService.getRoleByID(id);
        return new  ResponseEntity<>(role , HttpStatus.OK);
    }

    // modifying role
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseMessage> modifRole( @PathVariable(value = "id") int id, @RequestBody Role role) throws ResourceNotFoundException {
        String message =  this.roleService.modifRole(id, role) ;
        return new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.OK);
    }

    // deleting a role
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseMessage> deleteRole(@PathVariable(value="id") int id) throws ResourceNotFoundException {
        String message = this.roleService.deleteRole(id);
        return  new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.OK);
    }
}

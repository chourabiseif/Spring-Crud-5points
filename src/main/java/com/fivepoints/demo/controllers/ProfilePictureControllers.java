package com.fivepoints.demo.controllers;

import com.fivepoints.demo.models.ProfilePicture;
import com.fivepoints.demo.playLoad.responses.ResponseMessage;
import com.fivepoints.demo.services.ProfilePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ProfilePictureControllers {
    @Autowired
    ProfilePictureService profilePictureService;

    //adding a profile picture
    @RequestMapping(value = "/profilePictures/", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> createProfilePicture(@RequestParam("file") MultipartFile[] profilePictures){
        for (MultipartFile profilePicture : profilePictures){
        this.profilePictureService.SaveProfilePicture(profilePicture);
        }

        return new ResponseEntity<>(new ResponseMessage("photo ajouté") , HttpStatus.OK);
    }
    // get all pictures
    @RequestMapping(value = "/profilePictures/", method = RequestMethod.GET)
    public ResponseEntity<List<ProfilePicture>> getProfilePictures(){
        List<ProfilePicture> profilePictureList = this.profilePictureService.getAllProfilePictures();
        return new ResponseEntity<>(profilePictureList , HttpStatus.OK);

    }
    // get by id
    @RequestMapping(value = "/profilePictures/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProfilePicture> getProfilePicureByID(@PathVariable(value="id") int id){
        ProfilePicture profilePicture = this.profilePictureService.getProfilePicture(id) ;
        return  new ResponseEntity<>(profilePicture , HttpStatus.OK);
    }
}

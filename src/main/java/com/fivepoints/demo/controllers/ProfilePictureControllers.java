package com.fivepoints.demo.controllers;

import com.fivepoints.demo.models.About;
import com.fivepoints.demo.models.ProfilePicture;
import com.fivepoints.demo.models.User;
import com.fivepoints.demo.services.ProfilePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ProfilePictureControllers {
    @Autowired
    ProfilePictureService profilePictureService;
    //adding a profile picture
    @RequestMapping(value = "/profilePictures/", method = RequestMethod.POST)
    public String createProfilePicture(@RequestParam("file") MultipartFile[] profilePictures){
        for (MultipartFile profilePicture : profilePictures){
        this.profilePictureService.SaveProfilePicture(profilePicture);
        }

        return "photo ajouté";
    }
    // get all pictures
    @RequestMapping(value = "/profilePictures/", method = RequestMethod.GET)
    public List<ProfilePicture> getProfilePictures(){
        return this.profilePictureService.getAllProfilePictures();
    }
    // get by id
    @RequestMapping(value = "/profilePictures/{id}", method = RequestMethod.GET)
    public ProfilePicture getProfilePicureByID(@PathVariable(value="id") int id){
        return this.profilePictureService.getProfilePicture(id) ;
    }
}

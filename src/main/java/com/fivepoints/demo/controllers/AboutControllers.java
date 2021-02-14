package com.fivepoints.demo.controllers;

import com.fivepoints.demo.models.About;
import com.fivepoints.demo.models.Publication;
import com.fivepoints.demo.playLoad.responses.ResponseMessage;
import com.fivepoints.demo.services.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AboutControllers {
    @Autowired
    private AboutService aboutService;

    // create new  publication
    @RequestMapping(value = "/abouts/", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> createAbout(@RequestBody About about){
       String message =  this.aboutService.addAbout(about);
       return  new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.OK);
    }

    // get all the abouts
    @RequestMapping(value = "/abouts/", method = RequestMethod.GET)
    public ResponseEntity<List<About>> getAbouts(){

        List<About> aboutList = this.aboutService.getAbouts() ;
        return  new ResponseEntity<>(aboutList , HttpStatus.OK);
    }

    // get about by its id
    @RequestMapping(value = "/abouts/{id}", method = RequestMethod.GET)
    public ResponseEntity<About> getAboutByID(@PathVariable(value="id") int id){

        About about = this.aboutService.getAbout(id) ;
        return new  ResponseEntity<>(about , HttpStatus.OK);
    }
    // edit about
    @RequestMapping(value = "/abouts/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseMessage> updateAbout( @PathVariable(value = "id") int id, @RequestBody About about){
        String message =  this.aboutService.modifAbout(id, about) ;
        return new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.OK);
    }
    // delete publication
    @RequestMapping(value = "/abouts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseMessage> deleteAbout(@PathVariable(value="id") int id){
       String message = this.aboutService.deleteAbout(id);
       return  new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.OK);
    }
}

package com.fivepoints.demo.controllers;

import com.fivepoints.demo.models.Publication;


import com.fivepoints.demo.playLoad.responses.ResponseMessage;
import com.fivepoints.demo.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublicationsControllers {

    @Autowired
    PublicationService publicationService;
    // create new  publication
    @RequestMapping(value = "/publications/", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> createPublication(@RequestBody Publication publication){
        String message =  this.publicationService.addPublication(publication);
        return new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.OK);
    }

    // get all the publications
    @RequestMapping(value = "/publications/", method = RequestMethod.GET)
    public ResponseEntity<List<Publication>> getPublications(){

        List<Publication> publicationList = this.publicationService.getPublications() ;
        return  new ResponseEntity<>(publicationList , HttpStatus.OK);
    }

    // get publication by its id
    @RequestMapping(value = "/publications/{id}", method = RequestMethod.GET)
    public ResponseEntity<Publication> getPublicationByID(@PathVariable(value="id") int id){
        Publication publication = this.publicationService.getPublication(id) ;
        return  new ResponseEntity<>(publication , HttpStatus.OK);
    }

    // edit publication
    @RequestMapping(value = "/publications/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseMessage> updatePublication( @PathVariable(value = "id") int id, @RequestBody Publication publication){
       String message = this.publicationService.modifPublication(id, publication) ;
       return  new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.OK);
    }

    // delete publication
    @RequestMapping(value = "/publications/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseMessage> deletePublication(@PathVariable(value="id") int id){
        String message = this.publicationService.deletepublication(id);
        return  new ResponseEntity<>(new ResponseMessage(message) , HttpStatus.OK);
    }

}
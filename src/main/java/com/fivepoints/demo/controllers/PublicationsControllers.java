package com.fivepoints.demo.controllers;

import com.fivepoints.demo.models.Publication;


import com.fivepoints.demo.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublicationsControllers {

    @Autowired
    PublicationService publicationService;
    // create new  publication
    @RequestMapping(value = "/publications/", method = RequestMethod.POST)
    public String createPublication(@RequestBody Publication publication){
        return this.publicationService.addPublication(publication);
    }

    // get all the publications
    @RequestMapping(value = "/publications/", method = RequestMethod.GET)
    public List<Publication> getPublications(){
        return this.publicationService.getPublications() ;
    }

    // get publication by its id
    @RequestMapping(value = "/publications/{id}", method = RequestMethod.GET)
    public Publication getPublicationByID(@PathVariable(value="id") int id){
        return this.publicationService.getPublication(id) ;
    }

    // edit publication
    @RequestMapping(value = "/publications/{id}", method = RequestMethod.PUT)
    public String updatePublication( @PathVariable(value = "id") int id, @RequestBody Publication publication){
       return this.publicationService.modifPublication(id, publication) ;
    }

    // delete publication
    @RequestMapping(value = "/publications/{id}", method = RequestMethod.DELETE)
    public void deletePublication(@PathVariable(value="id") int id){
        this.publicationService.deletepublication(id);
    }

}
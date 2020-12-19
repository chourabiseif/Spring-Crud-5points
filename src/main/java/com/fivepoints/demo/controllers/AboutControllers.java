package com.fivepoints.demo.controllers;

import com.fivepoints.demo.models.About;
import com.fivepoints.demo.models.Publication;
import com.fivepoints.demo.services.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AboutControllers {
    @Autowired
    private AboutService aboutService;

    // create new  publication
    @RequestMapping(value = "/abouts/", method = RequestMethod.POST)
    public String createPublication(@RequestBody About about){
        return this.aboutService.addAbout(about);
    }
    // get all the abouts
    @RequestMapping(value = "/abouts/", method = RequestMethod.GET)
    public List<About> getAbouts(){
        return this.aboutService.getAbouts() ;
    }
    // get about by its id
    @RequestMapping(value = "/abouts/{id}", method = RequestMethod.GET)
    public About getAboutByID(@PathVariable(value="id") int id){
        return this.aboutService.getAbout(id) ;
    }
    // edit about
    @RequestMapping(value = "/abouts/{id}", method = RequestMethod.PUT)
    public String updateAbout( @PathVariable(value = "id") int id, @RequestBody About about){
        return this.aboutService.modifAbout(id, about) ;
    }
    // delete publication
    @RequestMapping(value = "/abouts/{id}", method = RequestMethod.DELETE)
    public void deleteAbout(@PathVariable(value="id") int id){
        this.aboutService.deleteAbout(id);
    }
}

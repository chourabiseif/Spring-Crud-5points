package com.fivepoints.demo.services;

import com.fivepoints.demo.models.About;
import com.fivepoints.demo.models.Publication;
import com.fivepoints.demo.repositories.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AboutService {
    @Autowired
    private AboutRepository aboutRepository;


    // adding a publication
    public String addAbout(About about){
        this.aboutRepository.save(about);
        return "about added";
    }

    //get all abouts
    public List<About> getAbouts(){

        return this.aboutRepository.findAll();
    }
    //get one about by its id
    public About getAbout(int id){

        return this.aboutRepository.findById(id).get();
    }
    //Modification

    public String modifAbout(int id, About about){
        About aboutfound = this.aboutRepository.findById(id).get();
        aboutfound.setBirthdate(about.getBirthdate());
        aboutfound.setCountry(about.getCountry());
        aboutfound.setCity(about.getCity());
        aboutfound.setPhoneNumber(about.getPhoneNumber());
        aboutfound.setZipCode(about.getZipCode());


        this.aboutRepository.save(aboutfound);
        return "about modified";
    }
    // deleting about
    public String deleteAbout(int id){
        this.aboutRepository.deleteById(id);
        return "about deleted";

    }
}
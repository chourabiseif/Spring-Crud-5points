package com.fivepoints.demo.services;

import com.fivepoints.demo.exceptions.ResourceNotFoundException;
import com.fivepoints.demo.models.About;
import com.fivepoints.demo.models.Publication;
import com.fivepoints.demo.repositories.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public About getAbout(int id) throws ResourceNotFoundException {
        Optional<About> about = this.aboutRepository.findById(id);
       return about.orElseThrow(() -> new ResourceNotFoundException("User about not found"));
    }

    //Modification
    public String modifAbout(int id, About about) throws ResourceNotFoundException {
        Optional<About> aboutData = this.aboutRepository.findById(id);
        if(aboutData.isPresent()){
            About aboutfound = aboutData.orElse(null);
            aboutfound.setBirthdate(about.getBirthdate());
            aboutfound.setCountry(about.getCountry());
            aboutfound.setCity(about.getCity());
            aboutfound.setPhoneNumber(about.getPhoneNumber());
            aboutfound.setZipCode(about.getZipCode());
            this.aboutRepository.save(aboutfound);
            return "about modified";
        }
        else {
            throw new ResourceNotFoundException("User about not found");
        }

    }
    // deleting about
    public String deleteAbout(int id) throws ResourceNotFoundException {
        Optional<About> about = this.aboutRepository.findById(id);
        if(about.isPresent()){
            this.aboutRepository.deleteById(id);
            return "about deleted";
        }
        else {
            throw new ResourceNotFoundException("User about not found");
        }


    }
}
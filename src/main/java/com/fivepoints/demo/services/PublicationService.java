package com.fivepoints.demo.services;

import com.fivepoints.demo.models.Publication;
import com.fivepoints.demo.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PublicationService {
    @Autowired
    PublicationRepository publicationRepository;

    // adding a publication
    public String addPublication(Publication publication){
        this.publicationRepository.save(publication);
        return "publication added";

    }
    //get all publications
    public List<Publication> getPublications(){

        return this.publicationRepository.findAll();
    }
    //get one publication by its id
    public Publication getPublication(int id){

        return this.publicationRepository.findById(id).get();
    }
    //Modification

    public String modifPublication(int id, Publication publication){
        Publication publicationfound = this.publicationRepository.findById(id).get();
        publicationfound.setDescription(publication.getDescription());
        publicationfound.setTitle(publication.getTitle());


        this.publicationRepository.save(publicationfound);
        return "modified";
    }
    // deleting publication
    public void deletepublication(int id){
        this.publicationRepository.deleteById(id);

    }
}

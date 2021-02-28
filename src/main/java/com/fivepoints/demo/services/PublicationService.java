package com.fivepoints.demo.services;

import com.fivepoints.demo.exceptions.ResourceNotFoundException;
import com.fivepoints.demo.models.Publication;
import com.fivepoints.demo.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Publication getPublication(int id) throws ResourceNotFoundException {
        Optional<Publication> publication = this.publicationRepository.findById(id);
        return publication.orElseThrow(()->new ResourceNotFoundException("Publication not found"));
    }
    //Modification

    public String modifPublication(int id, Publication publication) throws ResourceNotFoundException {
        Optional<Publication> publicationData  = this.publicationRepository.findById(id);
        if(publicationData.isPresent()){
            Publication publicationfound = publicationData.orElse(null);
            publicationfound.setDescription(publication.getDescription());
            publicationfound.setTitle(publication.getTitle());
            this.publicationRepository.save(publicationfound);
            return "publication modified";
    }else {
            throw new ResourceNotFoundException("Publication not found");
        }

    }
    // deleting publication
    public String deletepublication(int id) throws ResourceNotFoundException {
        Optional<Publication> publication = this.publicationRepository.findById(id);
        if(publication.isPresent()){
            this.publicationRepository.deleteById(id);
            return  "publication deleted";
        }
        else{
            throw new ResourceNotFoundException("Publication not found");
        }


    }
}

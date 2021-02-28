package com.fivepoints.demo.services;

import com.fivepoints.demo.exceptions.ResourceNotFoundException;
import com.fivepoints.demo.models.ProfilePicture;
import com.fivepoints.demo.repositories.ProfilePictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilePictureService {
    @Autowired
    private ProfilePictureRepository profilePictureRepository;

    // adding a profile Picture
    public ProfilePicture SaveProfilePicture(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {

            ProfilePicture profilePicture = new ProfilePicture(fileName, file.getContentType(), file.getBytes());
            return this.profilePictureRepository.save(profilePicture);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Get all profile pictures
    public List<ProfilePicture> getAllProfilePictures(){

        return this.profilePictureRepository.findAll();
    }

    // Get profile picture by id
    public ProfilePicture getProfilePicture(int id) throws ResourceNotFoundException {
        Optional<ProfilePicture> profilePicture = this.profilePictureRepository.findById(id);
        return profilePicture.orElseThrow(()->new ResourceNotFoundException("ProfilePicture Not Found"));
    }

    // Modifier profile picture






}

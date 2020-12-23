package com.fivepoints.demo.repositories;

import com.fivepoints.demo.models.ProfilePicture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilePictureRepository extends JpaRepository<ProfilePicture , Integer> {
}

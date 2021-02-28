package com.fivepoints.demo.repositories;

import com.fivepoints.demo.models.ERole;
import com.fivepoints.demo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    // find Role by name
    Optional<Role> findByName(ERole name);
}

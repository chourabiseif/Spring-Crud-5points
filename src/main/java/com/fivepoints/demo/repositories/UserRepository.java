package com.fivepoints.demo.repositories;

import com.fivepoints.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // SQL query without write query
    public User findByEmail(String email);

    // SQL query with write query
    @Query(value="SELECT * from users where first_name like %?1% and last_name like %?2%", nativeQuery = true)
    public List<User> searchUser(String firstName, String lastName);
}

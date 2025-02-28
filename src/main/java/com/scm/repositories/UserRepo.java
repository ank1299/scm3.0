package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User,String>{
    //extra methods db related operations
    //custom query method
    //custom finder methods

    //JPA will write implementation on its own
    Optional<User> findByEmail(String email);
    
}
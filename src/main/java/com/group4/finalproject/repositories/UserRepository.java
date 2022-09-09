package com.group4.finalproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group4.finalproject.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
}

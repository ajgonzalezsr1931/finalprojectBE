package com.group4.finalproject.services;

import java.util.List;
import java.util.Optional;

import com.group4.finalproject.entities.User;


public interface UserServices {
    List<User> getAll();

    void add(User user);

    void remove(User user);

    Optional<User> getUser(String email);
}

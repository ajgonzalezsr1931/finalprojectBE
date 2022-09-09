package com.group4.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.group4.finalproject.entities.User;
import com.group4.finalproject.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServicesImpl implements UserServices{

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(User user) {
        userRepository.delete(user);
    }

    @Override
    public Optional<User> getUser(String email) {
        return userRepository.findById(email);
    }
    
}

package com.group4.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void remove(String email) {
        userRepository.deleteById(email);
    }

    @Override
    public Optional<User> getUser(String email) {
        return userRepository.findById(email);
    }
    @Transactional
    @Override
    public User updateUser(String email, User user){
    Optional<User> usertoUpdateOptional= this.userRepository.findById(email);
    if (!usertoUpdateOptional.isPresent()){
        return null;
    }
    User usertoUpdate= usertoUpdateOptional.get();
    if(user.getEmail() != null){
        usertoUpdate.setEmail(user.getEmail());
    }
    if(user.getUsername() != null){
        usertoUpdate.setUsername(user.getUsername());
    }
    if(user.getPassword() != null){
        usertoUpdate.setPassword(user.getPassword());
    }
    User updatedUser = this.userRepository.save(usertoUpdate);
    return updatedUser;
}

}

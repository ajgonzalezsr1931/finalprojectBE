package com.group4.finalproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.finalproject.entities.User;
import com.group4.finalproject.repositories.UserRepository;
import com.group4.finalproject.services.UserServices;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private UserServices userServices;
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAll(){
        return userServices.getAll();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userServices.add(user);
    }

    @DeleteMapping("/delete/{email}")
    public void deleteById(@PathVariable String email){
        userServices.remove(email);
    }
    @PutMapping("update/{email}")
    public User updateUser(@PathVariable String email, @RequestBody User user){
        return userServices.updateUser(email, user);
    }
}


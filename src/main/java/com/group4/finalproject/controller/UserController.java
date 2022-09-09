package com.group4.finalproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.finalproject.entities.User;
import com.group4.finalproject.services.UserServices;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private UserServices userServices;

    @GetMapping("/all")
    public List<User> getAll(){
        return userServices.getAll();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userServices.add(user);
    }
}

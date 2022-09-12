package com.group4.finalproject.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group4.finalproject.entities.AppUser;
import com.group4.finalproject.services.AppUserServicesImpl;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class AppUserController {
    private AppUserServicesImpl userServicesImpl;

    @GetMapping("/all")
    public List<AppUser> getAll(){
        return userServicesImpl.getAll();
    }

    @Transactional
    @PostMapping("/add")
    public void addUser(@RequestBody AppUser user){
        userServicesImpl.register(user);
    }

    @DeleteMapping("/delete/{email}")
    public void deleteById(@PathVariable String email){
        userServicesImpl.remove(email);
    }
    @PutMapping("update/{email}")
    public AppUser updateUser(@PathVariable String email, @RequestBody AppUser user){
        return userServicesImpl.updateUser(email, user);
    }

}


package com.group4.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group4.finalproject.entities.User;
import com.group4.finalproject.entities.UserRole;
import com.group4.finalproject.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServicesImpl implements UserDetailsService{

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public List<User> getAll() {
        return userRepository.findAll();
    }
    
    public void remove(String email) {
        userRepository.deleteById(email);
    }

    public Optional<User> getUser(String email) {
        return userRepository.findById(email);
    }
    @Transactional
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
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
    User updatedUser = this.userRepository.save(usertoUpdate);
    return updatedUser;
}

    private final String USER_NOT_FOUND_MSG =   "USER WITH EMAIL %S NOT FOUND";

    public String register(User user){
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if (userExists){
            throw new IllegalStateException("Email is already used");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.setRole(UserRole.USER);
        userRepository.save(user);

        return "Registered";
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
}

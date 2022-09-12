package com.group4.finalproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group4.finalproject.entities.AppUser;
import com.group4.finalproject.entities.AppUserRole;
import com.group4.finalproject.repositories.AppUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserServicesImpl implements UserDetailsService{

    private final AppUserRepository appUserRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public List<AppUser> getAll() {
        return appUserRepository.findAll();
    }
    
    public void remove(String email) {
        appUserRepository.deleteById(email);
    }

    public Optional<AppUser> getUser(String email) {
        return appUserRepository.findById(email);
    }
    @Transactional
    public AppUser updateUser(String email, AppUser user){
    Optional<AppUser> usertoUpdateOptional= this.appUserRepository.findById(email);
    if (!usertoUpdateOptional.isPresent()){
        return null;
    }
    AppUser usertoUpdate= usertoUpdateOptional.get();
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
    AppUser updatedUser = this.appUserRepository.save(usertoUpdate);
    return updatedUser;
}

    private final String USER_NOT_FOUND_MSG =   "USER WITH EMAIL %S NOT FOUND";

    public String register(AppUser appUser){
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

        if (userExists){
            throw new IllegalStateException("Email is already used");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        appUser.setRole(AppUserRole.USER);
        appUserRepository.save(appUser);

        return "Registered";
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return appUserRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
}

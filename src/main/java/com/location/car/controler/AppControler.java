package com.location.car.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.location.car.model.User;
import com.location.car.repository.UserRepository;

@RestController
@RequestMapping("")
public class AppControler {
    @Autowired
    private UserRepository UserRepository;
    
    @PostMapping("/signin")
    public User signin(@RequestBody User newuser) {
        User user = new User();
        user.setUsername(newuser.getUsername());
        user.setPassword(newuser.getPassword());
        user.setEmail(newuser.getEmail());
        
        UserRepository.save(user);
        return user;
    }

    @PostMapping("/login")
    public @ResponseBody Optional<User> login (@RequestBody User newuser){
        return UserRepository.findUserByEmail(newuser.getEmail());
    }



}

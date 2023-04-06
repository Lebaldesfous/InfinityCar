package com.location.car.controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.location.car.model.User;
import com.location.car.repository.UserRepository;

@RestController
@CrossOrigin
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
        //find user by email or username and password
        if(UserRepository.findUserByEmailAndPassword(newuser.getEmail(), newuser.getPassword()).isPresent()){
            return UserRepository.findUserByEmailAndPassword(newuser.getEmail(), newuser.getPassword());
        }
        else if(UserRepository.findUserByEmailAndPassword(newuser.getUsername(), newuser.getPassword()).isPresent()){
            return UserRepository.findUserByEmailAndPassword(newuser.getUsername(), newuser.getPassword());
        }
        else{
            return null;
        }
    }

    @GetMapping("/users")
    public @ResponseBody Iterable<User> getAllUsers(){
        return UserRepository.findAll();
    }

}

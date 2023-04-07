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
        if(newuser.getUsername() == null || newuser.getPassword()==null || newuser.getEmail()==null){
            return null;
        }
        user.setUsername(newuser.getUsername());
        user.setPassword(newuser.getPassword());
        user.setEmail(newuser.getEmail());
        
        UserRepository.save(user);
        return user;
    }

    @PostMapping("/login")
    public @ResponseBody Optional<User> login (@RequestBody User newuser){
        //find user by email or username and password
        Optional<User> user = UserRepository.findUserByUsernameAndPassword(newuser.getUsername(), newuser.getPassword()).isPresent()?
                UserRepository.findUserByUsernameAndPassword(newuser.getUsername(), newuser.getPassword()):
                UserRepository.findUserByEmailAndPassword(newuser.getEmail(), newuser.getPassword());
        return user;
    }

    @GetMapping("/users")
    public @ResponseBody Iterable<User> getAllUsers(){
        return UserRepository.findAll();
    }

    @PutMapping("/users/{id}/update")
    public User updateUser(@PathVariable int id, @RequestBody User newuser){
        User user = UserRepository.findById(id).get();
        if(newuser.getUsername() != null){
            user.setUsername(newuser.getUsername());
        }
        if(newuser.getPassword() != null){
            user.setPassword(newuser.getPassword());
        }
        if(newuser.getEmail() != null){
            user.setEmail(newuser.getEmail());
        }
        UserRepository.save(user);
        return user;
    }

}

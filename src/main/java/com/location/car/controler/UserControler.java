package com.location.car.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location.car.repository.UserRepository;

@RestController
@RequestMapping("/account")
public class UserControler {
    @Autowired
    private UserRepository AccountRepository;
    


}

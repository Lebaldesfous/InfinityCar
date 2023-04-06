package com.location.car.repository;

import org.springframework.data.repository.CrudRepository;

import com.location.car.model.User;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Integer>{
    public Optional<User> findUserByEmailAndPassword(String email, String password);
    ///find user by email or username and password
    public Optional<User> findUserByUsernameAndPassword(String username, String password);

}

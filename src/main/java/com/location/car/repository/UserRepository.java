package com.location.car.repository;

import org.springframework.data.repository.CrudRepository;

import com.location.car.model.User;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Integer>{
    public Optional<User> findUserByEmail(String email);
}

package com.location.car.repository;

import org.springframework.data.repository.CrudRepository;

import com.location.car.model.Car;


public interface UserRepository extends CrudRepository<Car, Integer>{}

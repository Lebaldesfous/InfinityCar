package com.location.car.repository;

import org.springframework.data.repository.CrudRepository;

import com.location.car.model.Car;


public interface CarRepository extends CrudRepository<Car, Integer>{}
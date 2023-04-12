package com.location.car.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.location.car.model.Car;

@Service
public interface CarRepository extends CrudRepository<Car, Integer> {}
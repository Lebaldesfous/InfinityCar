package com.location.car.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.location.car.model.Car;
import com.location.car.repository.CarRepository;

@RestController
@RequestMapping("/car")
public class CarControler {
    @Autowired
    private CarRepository carRepository;
    // view all customers
    @GetMapping("")
    public @ResponseBody Iterable<Car> getAllCustomers(){
        return carRepository.findAll();
    }

    @PostMapping("/add")
    public Car addCar(@RequestBody Car newCar) {
        Car car = new Car();
        car.setName(newCar.getName());
        car.setModel(newCar.getModel());
        car.setPrice(newCar.getPrice());
        car.setPictureUrl(newCar.getPictureUrl());
        carRepository.save(car);
        return car;
        
    }
}

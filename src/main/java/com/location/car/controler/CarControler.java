package com.location.car.controler;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.location.car.model.Car;
import com.location.car.repository.CarRepository;

@RestController
@CrossOrigin
@RequestMapping("/cars")
public class CarControler {

    @Autowired
    private CarRepository carRepository;

    public CarControler(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    // view all customers
    @GetMapping("")
    public @ResponseBody Iterable<Car> getAllCars(){
        return carRepository.findAll();
    }

    @PostMapping("/add")
    public Car addCar(@RequestBody Car newCar) {
        Car car = new Car();
        car.setName(newCar.getName());
        car.setModel(newCar.getModel());
        car.setPrice(newCar.getPrice());
        car.setPictureUrl(newCar.getPictureUrl());
        car.setFuel_efficiency(newCar.getFuel_efficiency());
        car.setEngine(newCar.getEngine());
        car.setHorsepower(newCar.getHorsepower());
        carRepository.save(car);
        return car;
    }

    @GetMapping("/{id}")
    public @ResponseBody Optional<Car> getCarById(@PathVariable int id){
        return carRepository.findById(id);
    }

    //modify car by id and check if each field is null and if it is then get the old value
    @PutMapping("/{id}/update")
    public Car updateCar(@PathVariable int id, @RequestBody Car newCar){
        Car car = carRepository.findById(id).get();
        if(newCar.getName() != null){
            car.setName(newCar.getName());
        }
        if(newCar.getModel() != null){
            car.setModel(newCar.getModel());
        }
        if(newCar.getPrice() != 0){
            car.setPrice(newCar.getPrice());
        }
        if(newCar.getPictureUrl() != null){
            car.setPictureUrl(newCar.getPictureUrl());
        }
        if(newCar.getFuel_efficiency() != 0){
            car.setFuel_efficiency(newCar.getFuel_efficiency());
        }
        if(newCar.getEngine() != null){
            car.setEngine(newCar.getEngine());
        }
        if(!newCar.getHorsepower().equals("")){
            car.setHorsepower(newCar.getHorsepower());
        }
        carRepository.save(car);
        return car;
    }

    @DeleteMapping("/{id}/delete")
    public void deleteCar(@PathVariable int id){
        carRepository.deleteById(id);
    }
}

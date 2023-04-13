package com.location.car.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.location.car.model.CarDTO;
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
    public @ResponseBody List<CarDTO> getAllCars() {
        List<Car> cars = (List<Car>) carRepository.findAll();
        List<CarDTO> carDTOs = new ArrayList<>();
        for (Car car : cars) {
            CarDTO carDTO = new CarDTO(car.getId(), car.getName(), car.getModel(), car.getPrice(), car.getPictureUrl(), car.getFuel_efficiency(), car.getEngine(), car.getHorsepower(), car.getStock());
            carDTOs.add(carDTO);
        }
        return carDTOs;
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
        car.setStock(newCar.getStock());
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
        if(newCar.getPrice() >= 0){
            car.setPrice(newCar.getPrice());
        }
        if(newCar.getPictureUrl() != null){
            car.setPictureUrl(newCar.getPictureUrl());
        }
        if(newCar.getFuel_efficiency() >= 0){
            car.setFuel_efficiency(newCar.getFuel_efficiency());
        }
        if(newCar.getEngine() != null){
            car.setEngine(newCar.getEngine());
        }
        if(!newCar.getHorsepower().equals("")){
            car.setHorsepower(newCar.getHorsepower());
        }
        if(newCar.getStock() >= 0) {
            car.setStock(newCar.getStock());
        }
        carRepository.save(car);
        return car;
    }

    @DeleteMapping("/{id}/delete")
    public void deleteCar(@PathVariable int id){
        carRepository.deleteById(id);
    }
}

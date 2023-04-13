package com.location.car.controler;

import com.location.car.model.Car;
import com.location.car.model.Order;
import com.location.car.model.OrderRequest;
import com.location.car.model.User;
import com.location.car.repository.CarRepository;
import com.location.car.repository.OrderRepository;
import com.location.car.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderControleur {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody OrderRequest orderRequest) {
        Optional<User> user = userRepository.findById(orderRequest.getUserId());
        Optional<Car> car = carRepository.findById(orderRequest.getCarId());

        if (user.isPresent() && car.isPresent()) {
            Order order = new Order(car.get(), user.get(), orderRequest.getTotalPrice());
            orderRepository.save(order);
            Car updatedCar = car.get();
            updatedCar.setStock(updatedCar.getStock() - 1);
            carRepository.save(updatedCar);
            return ResponseEntity.ok("Order added successfully");
        } else {
            return ResponseEntity.badRequest().body("User or car not found");
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<Order> orders = orderRepository.findByUser(user.get());
            return ResponseEntity.ok(orders);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}/delete")
    public void deleteOrder(@PathVariable int id){
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()){
            Car updatedCar = car.get();
            updatedCar.setStock(updatedCar.getStock() + 1);
            carRepository.save(updatedCar);
        }
        orderRepository.deleteById(id);
    }
}
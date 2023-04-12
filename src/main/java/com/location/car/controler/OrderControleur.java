package com.location.car.controler;

import java.util.Optional;


import com.location.car.model.Order;
import com.location.car.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderControleur {

    @Autowired
    private final OrderRepository OrderRepository;

    public OrderControleur(OrderRepository OrderRepository) {
        this.OrderRepository = OrderRepository;
    }

    @GetMapping("/{id}")
    public @ResponseBody Iterable<Order> getOrderById(@PathVariable int id){
        return OrderRepository.findOrderByIdUser(id);
    }

    @PostMapping("/add")
    public @ResponseBody Order addOrder(@RequestBody Order neworder){
        Order order= new Order();
        order.setUser_id(neworder.getUser_id());
        order.setCar_id(neworder.getCar_id());
        order.setTotal_price(neworder.getTotal_price());
        OrderRepository.save(order);
        return order;
    }
}

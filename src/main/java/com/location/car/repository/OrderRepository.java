package com.location.car.repository;

import com.location.car.model.Order;
import org.springframework.data.repository.CrudRepository;



public interface OrderRepository extends CrudRepository<Order, Integer>{
    public Iterable<Order> findOrderByIdUser(int id);
}
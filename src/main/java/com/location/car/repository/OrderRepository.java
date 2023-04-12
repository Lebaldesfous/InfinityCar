package com.location.car.repository;

import com.location.car.model.Order;
import com.location.car.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderRepository extends CrudRepository<Order, Integer>{
    List<Order> findByUser(User user);
    //public Iterable<Order> findOrderByUser_id(Long idUser);
}



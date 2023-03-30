package com.location.car.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "car")
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private int price;

    @Column(name = "pictureUrl")
    private String pictureUrl;

}

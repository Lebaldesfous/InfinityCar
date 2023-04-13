package com.location.car.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Set;

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

    @Column(name = "fuel_efficiency")
    private int fuel_efficiency;

    @Column(name = "engine")
    private String engine;

    @Column(name = "horsepower")
    private String horsepower;

    @Column(name = "stock")
    private int stock;



    public Car() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getPictureUrl(){
        return pictureUrl;
    }
    public void setPictureUrl(String pictureUrl){
        this.pictureUrl = pictureUrl;
    }

    public int getFuel_efficiency() {
        return fuel_efficiency;
    }

    public void setFuel_efficiency(int fuel_efficiency) {
        this.fuel_efficiency = fuel_efficiency;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = horsepower;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public long getId(){
        return this.id;
    }

    public String toString(){
        return ("Car: " + this.name + " " + this.model + " " + this.price + " " + this.pictureUrl + " " + this.fuel_efficiency + " " + this.engine + " " + this.horsepower + " " + this.stock);
    }

}

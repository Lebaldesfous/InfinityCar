package com.location.car.model;
public class CarDTO {
    private long id;
    private String name;
    private String model;
    private double price;
    private String pictureUrl;
    private double fuel_efficiency;
    private String engine;
    private String horsepower;

    private int stock;

    public CarDTO(long id, String name, String model, double price, String pictureUrl, double fuel_efficiency, String engine, String horsepower, int stock) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.fuel_efficiency = fuel_efficiency;
        this.engine = engine;
        this.horsepower = horsepower;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public double getFuel_efficiency() {
        return fuel_efficiency;
    }

    public String getEngine() {
        return engine;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setFuel_efficiency(double fuel_efficiency) {
        this.fuel_efficiency = fuel_efficiency;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = horsepower;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
package com.location.car.model;
public class OrderRequest {
    private int userId;
    private int carId;
    private int totalPrice;

    public OrderRequest(int userId, int carId, int totalPrice) {
        this.userId = userId;
        this.carId = carId;
        this.totalPrice = totalPrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
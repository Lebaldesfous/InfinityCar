package com.location.car.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "order")
public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "car_id")
        @NonNull
        private Long car_id;

        @Column(name = "user_id")
        @NonNull
        private Long user_id;

        @Column(name = "total_price")
        @NonNull
        private int total_price;

        public Order() {
        }
        public Long getCar_id() {
            return car_id;
        }
        public void setCar_id(Long car_id) {
            this.car_id = car_id;
        }
        public Long getUser_id() {
            return user_id;
        }
        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }
        public int getTotal_price() {
            return total_price;
        }
        public void setTotal_price(int total_price) {
            this.total_price = total_price;
        }
}

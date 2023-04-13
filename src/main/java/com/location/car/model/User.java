package com.location.car.model;

import io.micrometer.common.lang.NonNull;

import jakarta.persistence.*;

import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "account")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    @NonNull
    private String username;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "role")
    @NonNull
    private String role;

   public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public long getId() {
       return this.id;
    }

    public void setRole(String role) {
       this.role = role;
    }
    public String getRole() {
       return this.role;
    }
}

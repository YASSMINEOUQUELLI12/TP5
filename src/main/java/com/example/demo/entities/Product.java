package com.example.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;

    public Product() {}

    public void setName(String s) {
        this.name = s;
    }

    public void setPrice(double v) {
        this.price = v;
    }

    public String getName() {
        return this.name;
    }

    // Getters et Setters
}

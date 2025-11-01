package com.example.entities;


import jakarta.persistence.*;



@Entity
@Table(name = "product") // facultatif, mais bonne pratique
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false) // évite des valeurs null
    private String name;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    @Column(nullable = false)
    private double price;



    public Product() {}

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }



    // Getters et Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}




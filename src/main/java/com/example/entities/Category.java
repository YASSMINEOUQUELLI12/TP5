package com.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false, unique=true)
    private String label;

    public Category(String label) {
        this.label = label;
    }

    public Category() {

    }

    public void setLabel(String informatique) {
        this.label = informatique;
    }
    public String getLabel() {
        return this.label;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int informatique) {
        this.id = informatique;
    }



    // getters/setters/constructeurs
}


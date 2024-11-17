package com.example.capybara.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Capybara {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    String name;
    String color;

    public Capybara() {

    }

    public Capybara(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Long getId() { return Id; }
    public void setId(Long id) { this.Id = id; }

    public String name() {
        return null;
    }
}

package com.example.capybara.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Capybara {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String color;
    private long identifier;

    public Capybara() {

    }

    public Capybara(String name, String color) {
        this.name = name;
        this.color = color;
        this.identifier = calculateIdentifier();
    }

    private long calculateIdentifier() {
        long sum = 0;

        if (name != null) {
            for (char c : name.toCharArray()) {
                sum += c;
            }
        }

        // Dodaj wartości znaków z lastName
        if (color != null) {
            for (char c : color.toCharArray()) {
                sum += c;
            }
        }
        return sum;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        this.identifier = calculateIdentifier();
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
        this.identifier = calculateIdentifier();
    }
    public Long getId() { return Id; }
    public void setId(Long id) { this.Id = id; }
    public long getIdentifier() { return identifier; }

    public String name() {
        return null;
    }
}


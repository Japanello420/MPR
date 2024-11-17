package com.example.springboottutorial.model;

public class Capybara {
    String name;
    String color;

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

    public String name() {
        return null;
    }
}

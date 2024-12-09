package com.example.capybara.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddCapybaraTest {
    private WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        this.webDriver = new ChromeDriver();
//        this.webDriver = new FirefoxDriver();
//        this.webDriver = new EdgeDriver();
    }

    @Test
    public void testAddCapybaraForm() {
        AddCapybaraPage page = new AddCapybaraPage(webDriver)
                .open()
                .fillInNameInput("Kamil")
                .fillInColorInput("Czarny")
                .submitForm();
    }
}

package com.example.capybara.controllers;


import com.example.capybara.services.CapybaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/capybara")
public class MyViewController {
    private final CapybaraService capybaraService;

    @Autowired
    public MyViewController(CapybaraService capybaraService) {
        this.capybaraService = capybaraService;
    }

}

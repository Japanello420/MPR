package com.example.springboottutorial.controllers;

import com.example.springboottutorial.model.Capybara;
import com.example.springboottutorial.services.CapybaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRestController {
    private CapybaraService capybaraService;

    @Autowired
    public MyRestController(CapybaraService capybaraService) {
        this.capybaraService = capybaraService;
    }

    @GetMapping("capybara/getall")
    public List<Capybara> getAll () {
        return this.capybaraService.getCapybaraList();
    }

    @GetMapping("capybara/{id}")
    public Capybara get(@PathVariable int id) {
        return this.capybaraService.getCapybara(id);
    }

    @PostMapping("capybara/add")
    public void addCapybara(@RequestBody Capybara capybara) {
        this.capybaraService.add(capybara);
    }

    @DeleteMapping("capybara/delete/{id}")
    public void delete(@PathVariable int id) {
        CapybaraService.remove(id);
    }

    @PutMapping("capybara/zmien/{id}")
    public void zmien(@PathVariable int id, @RequestBody Capybara capybara) {
        capybaraService.zmien(id, capybara);
    }


}

package com.example.capybara.controllers;

import com.example.capybara.model.Capybara;
import com.example.capybara.services.CapybaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyRestController {
    private CapybaraService capybaraService;

    @Autowired
    public MyRestController(CapybaraService capybaraService) {
        this.capybaraService = capybaraService;
    }

//    @GetMapping("capybara/getall")
//    public List<Capybara> getAll () {
//        return this.capybaraService.getCapybaraList();
//    }
//
//    @GetMapping("capybara/{id}")
//    public Capybara get(@PathVariable int id) {
//        return this.capybaraService.getCapybara(id);
//    }

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

    @GetMapping("capybara/name/{name}")
    public List<Capybara> findByName(@PathVariable String name) {
        return this.capybaraService.getByName(name);
    }

    @GetMapping("capybara/color/{color}")
    public List<Capybara> findByColor(@PathVariable String color) {
        return this.capybaraService.getByColor(color);
    }

    @GetMapping("capybara/id/{Id}")
    public Optional<Capybara> findById(@PathVariable Long Id) {
        return this.capybaraService.getById(Id);
    }


}

package com.example.capybara.controllers;

import com.example.capybara.model.Capybara;
import com.example.capybara.services.CapybaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/capybaras")
public class MyRestController {
    private final CapybaraService capybaraService;

    @Autowired
    public MyRestController(CapybaraService capybaraService) {
        this.capybaraService = capybaraService;
    }

    @GetMapping("/getall")
    public List<Capybara> getAll() {
        return this.capybaraService.getAllCapybaras();
    }

    @PostMapping("/add")
    public void addCapybara(@RequestBody Capybara capybara) {
        this.capybaraService.addCapybara(capybara);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        capybaraService.deleteCapybara(id);
    }

    @PutMapping("/zmien/{id}")
    public ResponseEntity<Capybara> zmien(@PathVariable Long id, @RequestBody Capybara capybara) {
        try {
            Capybara updatedCapybara = capybaraService.updateCapybara(id, capybara);
            return ResponseEntity.ok(updatedCapybara);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public List<Capybara> findByName(@PathVariable String name) {
        return this.capybaraService.getByName(name);
    }

    @GetMapping("/color/{color}")
    public List<Capybara> findByColor(@PathVariable String color) {
        return this.capybaraService.getByColor(color);
    }

    @GetMapping("/id/{Id}")
    public Optional<Capybara> findById(@PathVariable Long Id) {
        return this.capybaraService.getById(Id);
    }
}
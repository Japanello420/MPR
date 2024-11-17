package com.example.capybara.services;

import com.example.capybara.model.Capybara;
import com.example.capybara.repository.CapybaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapybaraService {
    private final CapybaraRepository repository;

    @Autowired
    public CapybaraService(CapybaraRepository repository) {
        this.repository = repository;

        repository.save(new Capybara("Cezary", "Czarnuch"));
        repository.save(new Capybara("Milkyway", "Galaxy"));
        repository.save(new Capybara("Cowboy", "Milky"));
    }

    public List<Capybara> getByName(String name) {
        return repository.findByName(name);
    }

    public Optional<Capybara> getById(Long id) {
        return repository.findById(id);
    }

    public List<Capybara> getByColor(String color) {
        return repository.findByColor(color);
    }

    public Capybara addCapybara(Capybara capybara) {
        return repository.save(capybara);
    }

    public Capybara updateCapybara(Long id, Capybara updatedCapybara) {
        return repository.findById(id).map(existingCapybara -> {
            if (updatedCapybara.getName() != null) {
                existingCapybara.setName(updatedCapybara.getName());
            }
            if (updatedCapybara.getColor() != null) {
                existingCapybara.setColor(updatedCapybara.getColor());
            }
            return repository.save(existingCapybara);
        }).orElseThrow(() -> new RuntimeException("Capybara o podanym ID nie istnieje!"));
    }

    public void deleteCapybara(Long id) {
        repository.deleteById(id);
    }

    public List<Capybara> getAllCapybaras() {
        return (List<Capybara>) repository.findAll();
    }
}

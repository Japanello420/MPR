package com.example.capybara.services;

import com.example.capybara.model.Capybara;
import com.example.capybara.repository.CapybaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CapybaraService {
    private CapybaraRepository repository;

    static List<Capybara> capybaraList = new ArrayList<>();

    @Autowired
    public CapybaraService(CapybaraRepository repository) {
        this.repository = repository;

        repository.save(new Capybara("Cezary", "Czarnuch"));
        repository.save(new Capybara("Milkyway", "Galaxy"));
        repository.save(new Capybara("Cowboy", "Milky"));

//        this.capybaraList.add(new Capybara("Cezary", "Czarnuch"));
//        this.capybaraList.add(new Capybara("Milkyway", "Galaxy"));
//        this.capybaraList.add(new Capybara("Cowboy", "Milky"));
    }

    public List<Capybara> getByName(String name) {
        return this.repository.findByName(name);
    }

    public Optional<Capybara> getById(Long Id) {
        return this.repository.findById(Id);
    }

    public List<Capybara> getByColor(String color) {
        return this.repository.findByColor(color);
    }
    


//    public List<Capybara> getCapybaraList() {
//        return this.capybaraList;
//    }

    public void add(Capybara capybara) {
        this.capybaraList.add(capybara);
    }

//    public Capybara getCapybara(Integer id) {
//        return this.capybaraList.get(id);
//    }



    public static void remove(int id) {
        if (id >= 0 && id < capybaraList.size()) {
            capybaraList.remove(id);
        }
    }

    public void zmien(int id, Capybara capybara) {
        if (id >= 0 && id < capybaraList.size()) {
            Capybara existingCapybara = capybaraList.get(id);
            existingCapybara.setName(capybara.getName());
            existingCapybara.setColor(capybara.getColor());
        }
    }


}

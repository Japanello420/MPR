package com.example.springboottutorial.services;

import com.example.springboottutorial.model.Capybara;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CapybaraService {
    static List<Capybara> capybaraList = new ArrayList<>();

    public CapybaraService() {
        this.capybaraList.add(new Capybara("Cezary", "Czarnuch"));
        this.capybaraList.add(new Capybara("Milkyway", "Galaxy"));
        this.capybaraList.add(new Capybara("Cowboy", "Milky"));
    }

    public List<Capybara> getCapybaraList() {
        return this.capybaraList;
    }

    public void add(Capybara capybara) {
        this.capybaraList.add(capybara);
    }

    public Capybara getCapybara(Integer id) {
        return this.capybaraList.get(id);
    }



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

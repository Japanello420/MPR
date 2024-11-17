package com.example.capybara.repository;

import com.example.capybara.model.Capybara;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CapybaraRepository extends CrudRepository<Capybara, Long> {
    public List<Capybara> findByName(String name);
    public Optional<Capybara> findById(Long id);
    public List<Capybara> findByColor(String color);
}

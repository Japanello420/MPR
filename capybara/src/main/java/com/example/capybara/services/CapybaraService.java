package com.example.capybara.services;

import com.example.capybara.model.Capybara;
import com.example.capybara.repository.CapybaraRepository;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.List;
import java.io.File;
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

    public byte[] generatePdfForCapybara(Capybara capybara) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            File fontFile = new File("src/main/resources/fonts/Helvetica.ttf");
            PDType0Font customFont = PDType0Font.load(document, fontFile);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(customFont, 12);
                contentStream.setLeading(14.5f);
                contentStream.newLineAtOffset(50, 750);

                contentStream.showText("Capybara Details:");
                contentStream.newLine();
                contentStream.showText("Id: " + capybara.getId());
                contentStream.newLine();
                contentStream.showText("Name: " + capybara.getName());
                contentStream.newLine();
                contentStream.showText("Color: " + capybara.getColor());
                contentStream.newLine();
                contentStream.showText("Identifier: " + capybara.getIdentifier());

                contentStream.endText();
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            document.save(outputStream);
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }
}

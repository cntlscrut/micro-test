package com.example.animalimageservice.controller;

import com.example.animalimageservice.model.AnimalImage;
import com.example.animalimageservice.service.AnimalImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalImageController {

    private final AnimalImageService service;

    public AnimalImageController(AnimalImageService service) {
        this.service = service;
    }

    @PostMapping("/{animalType}/{count}")
    public ResponseEntity<List<AnimalImage>> saveAnimalImages(
            @PathVariable String animalType, @PathVariable int count) {
        List<AnimalImage> savedImages = service.fetchAndSaveAnimalImages(animalType, count);
        return ResponseEntity.ok(savedImages);
    }

    @GetMapping("/{animalType}/last")
    public ResponseEntity<AnimalImage> getLastAnimalImage(@PathVariable String animalType) {
        AnimalImage lastImage = service.getLastImage(animalType);
        return lastImage != null ? ResponseEntity.ok(lastImage) : ResponseEntity.notFound().build();
    }
}
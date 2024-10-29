package com.example.animalimageservice.controller;

import com.example.animalimageservice.model.AnimalImage;
import com.example.animalimageservice.service.AnimalImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalImageController {

    private final AnimalImageService service;

    public AnimalImageController(AnimalImageService service) {
        this.service = service;
    }

    @PostMapping("/{animalType}/{count}")
    public ResponseEntity<List<AnimalImage>> saveAnimalImages(@PathVariable String animalType, @PathVariable int count) {
        try {
            List<AnimalImage> savedImages = service.fetchAndSaveImages(animalType, count);
            return ResponseEntity.ok(savedImages);
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/{animalType}/last", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getLastAnimalImage(@PathVariable String animalType) {
        AnimalImage lastImage = service.getLastImage(animalType);

        if (lastImage != null && lastImage.getImageData() != null) {
            // Return the image data with JPEG content type
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(lastImage.getImageData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
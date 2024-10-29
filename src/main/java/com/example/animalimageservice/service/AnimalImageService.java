package com.example.animalimageservice.service;

import com.example.animalimageservice.model.AnimalImage;
import com.example.animalimageservice.repository.AnimalImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalImageService {

    private static final Logger log = LoggerFactory.getLogger(AnimalImageService.class);
    private final AnimalImageRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();

    public AnimalImageService(AnimalImageRepository repository) {
        this.repository = repository;
    }

    public List<AnimalImage> fetchAndSaveImages(String animalType, int count) throws IOException {
        List<AnimalImage> savedImages = new ArrayList<>();
        String url = getAnimalUrl(animalType);

        for (int i = 0; i < count; i++) {
            // Fetch image data
            InputStream inputStream = new URL(url).openStream();
            byte[] imageData = inputStream.readAllBytes();
            //log.info(imageData.toString());
            // Save image metadata to the database
            AnimalImage animalImage = new AnimalImage(animalType, url, imageData);
            savedImages.add(repository.save(animalImage));
        }

        return savedImages;
    }

    public AnimalImage getLastImage(String animalType) {
        return repository.findFirstByAnimalTypeOrderByIdDesc(animalType).orElse(null);
    }

    private String getAnimalUrl(String animalType) {
        switch (animalType.toLowerCase()) {
            case "dog":
                return "https://place.dog/400/300";
            case "bear":
                return "https://placebear.com/400/300";
            default:
                throw new IllegalArgumentException("Unknown animal type");
        }
    }
}
package com.example.animalimageservice.service;

import com.example.animalimageservice.model.AnimalImage;
import com.example.animalimageservice.repository.AnimalImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalImageService {

    private final AnimalImageRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();

    public AnimalImageService(AnimalImageRepository repository) {
        this.repository = repository;
    }

    public List<AnimalImage> fetchAndSaveAnimalImages(String animalType, int count) {
        String url;
        switch (animalType.toLowerCase()) {
            case "cat":
                url = "https://placekitten.com/200/300";
                break;
            case "dog":
                url = "https://place.dog/200/300";
                break;
            case "bear":
                url = "https://placebear.com/200/300";
                break;
            default:
                throw new IllegalArgumentException("Unknown animal type");
        }

        for (int i = 0; i < count; i++) {
            // Save each image
            AnimalImage animalImage = new AnimalImage(animalType, url);
            repository.save(animalImage);
        }
        return repository.findAll();
    }

    public Optional<AnimalImage> getLastImage(String animalType) {
        return repository.findFirstByAnimalTypeOrderByIdDesc(animalType);
    }
}
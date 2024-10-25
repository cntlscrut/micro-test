package com.example.animalimageservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AnimalImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String animalType;
    private String imageUrl;

    public AnimalImage() {}

    public AnimalImage(String animalType, String imageUrl) {
        this.animalType = animalType;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
}
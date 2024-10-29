package com.example.animalimageservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class AnimalImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String animalType;
    private String imageUrl;

    @Lob
    private byte[] imageData;

    public AnimalImage() {}

    public AnimalImage(String animalType, String imageUrl, byte[] imageData) {
        this.animalType = animalType;
        this.imageUrl = imageUrl;
        this.imageData = imageData;
    }

    // Getters and Setters
    public byte[] getImageData() {
        return imageData;
    }
}
package com.example.animalimageservice.repository;

import com.example.animalimageservice.model.AnimalImage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AnimalImageRepository extends JpaRepository<AnimalImage, Long> {
    Optional<AnimalImage> findFirstByAnimalTypeOrderByIdDesc(String animalType);
}
package com.gwa.expos.controller;

import com.gwa.expos.model.Animal;
import com.gwa.expos.service.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

  private final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @GetMapping("/")
  List<Animal> getAnimals() {
    return animalService.getAnimalList();
  }

  @GetMapping("/{id}")
  ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
    return animalService.getAnimalById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }
}

package com.gwa.expos.service;

import com.gwa.expos.model.Animal;
import com.gwa.expos.model.AnimalColor;
import com.gwa.expos.model.AnimalType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AnimalService {

  private List<Animal> animalList = new ArrayList<>();
  private AtomicLong idProvider = new AtomicLong(1);

  public AnimalService() {
    animalList.add(new Animal(idProvider.getAndIncrement(), "Joe", AnimalColor.RED, AnimalType.CAT));
    animalList.add(new Animal(idProvider.getAndIncrement(), "Flower", AnimalColor.WHITE, AnimalType.CAT));
    animalList.add(new Animal(idProvider.getAndIncrement(), "Rambo", AnimalColor.BLACK, AnimalType.DOG));
    animalList.add(new Animal(idProvider.getAndIncrement(), "Pluto", AnimalColor.BROWN, AnimalType.DOG));
    animalList.add(new Animal(idProvider.getAndIncrement(), "Roger", AnimalColor.WHITE, AnimalType.RABBIT));
    animalList.add(new Animal(idProvider.getAndIncrement(), "Greg", AnimalColor.WHITE, AnimalType.HUMAN));
  }

  public List<Animal> getAnimalList() {
    return animalList;
  }

  public Optional<Animal> getAnimalById(Long id) {
    return animalList.stream()
        .filter(animal -> Objects.equals(animal.id(), id))
        .findFirst();
  }
}

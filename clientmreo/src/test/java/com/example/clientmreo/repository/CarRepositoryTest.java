package com.example.clientmreo.repository;

import com.example.clientmreo.entity.Car;
import com.example.clientmreo.entity.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CarRepositoryTest {
    @Autowired
    CarRepository carRepository;
    @Autowired
    OwnerRepository ownerRepository;
    Car car = new Car(1L, "BMW", "X6", 2000, "HY573P4738583", "UH758U", new Owner());
    Owner owner = new Owner(2L, "Alexey", "Mihailovich", "Petrov", "UH74839UY");
    @BeforeEach
    void init() {
        carRepository.save(car);
        ownerRepository.save(owner);
    }
    @AfterEach
    void clear() {
        carRepository.deleteAll();
        ownerRepository.deleteAll();
    }

    @Test
    void updateCarTable_carExternalKey_whenOwnerChanged() {
        carRepository.updateCarTable(owner.getId(), car.getVinNumber());
        assertEquals(owner.getId(), carRepository.findById(car.getId()).get().getOwner().getId());
    }
}
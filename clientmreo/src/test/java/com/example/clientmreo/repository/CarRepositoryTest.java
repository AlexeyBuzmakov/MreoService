package com.example.clientmreo.repository;

import com.example.clientmreo.dto.CarDto;
import com.example.clientmreo.dto.OwnerDto;
import com.example.clientmreo.entity.CarEntity;
import com.example.clientmreo.entity.OwnerEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CarRepositoryTest {
    @Autowired
    CarRepository carRepository;
    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void updateCarTable() {
        CarEntity carEntity = new CarEntity(1L, "BMW", "X6", 2000, "HY573P4738583", "UH758U", new OwnerEntity());
        OwnerEntity ownerEntity = new OwnerEntity(2L, "Alexey", "Mihailovich", "Petrov", "UH74839UY");
        carRepository.save(carEntity);
        ownerRepository.save(ownerEntity);
        Long id = ownerEntity.getId();
        carRepository.updateCarTable(ownerEntity.getId(), carEntity.getVinNumber());
        assertEquals(id, carRepository.findById(carEntity.getId()).get().getOwnerEntity().getId());
    }
}
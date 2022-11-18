package com.example.clientmreo.service.impl;

import com.example.clientmreo.entity.Car;
import com.example.clientmreo.entity.Owner;
import com.example.clientmreo.repository.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class CarServiceImplTest {
    @Mock
    CarRepository carRepository;
    Car car = new Car(1L, "Toyota", "Prius", 2000, "1111", "1111", new Owner());

    @BeforeEach
    void init() {
        carRepository.save(car);
    }

    @AfterEach
    void clear() {
        carRepository.deleteAll();
    }

    @Test
    void updateCarTable() {
        when(carRepository.getCarEntityByVinNumber(any().toString()))
                .thenReturn(null);

        when(carRepository.save(any(Car.class)))
        .thenReturn(car);


    }
}
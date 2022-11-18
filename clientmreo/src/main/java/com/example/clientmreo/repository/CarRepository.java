package com.example.clientmreo.repository;

import com.example.clientmreo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    /**
     * Метод возвращает Car по vin_number из car_table
     */
    Optional<Car> getCarByVinNumber(String vinNumber);
}

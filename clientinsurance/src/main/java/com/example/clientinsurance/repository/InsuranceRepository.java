package com.example.clientinsurance.repository;

import com.example.clientinsurance.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    /**
     * Метод возвращает Insurance по number_car из таблицы insurance_table
     */
    Optional<Insurance> getInsuranceByNumberCar(String numberCar);
}

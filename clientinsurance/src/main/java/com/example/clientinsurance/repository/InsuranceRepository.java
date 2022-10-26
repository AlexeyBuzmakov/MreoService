package com.example.clientinsurance.repository;

import com.example.clientinsurance.entity.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {
    /**
     * Метод возвращает InsuranceEntity по number_car из таблицы insurance_table
     */
    InsuranceEntity getClientEntityByNumberCar(String number);
}

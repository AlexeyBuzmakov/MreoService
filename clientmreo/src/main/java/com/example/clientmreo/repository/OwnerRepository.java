package com.example.clientmreo.repository;

import com.example.clientmreo.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
    /**
     * Метод возвращает OwnerEntity по driver_license из таблицы owner_table
     */
    OwnerEntity getOwnerEntityByDriverLicense(String driverLicense);
}


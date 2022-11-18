package com.example.clientmreo.repository;

import com.example.clientmreo.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    /**
     * Метод возвращает Owner по driver_license из таблицы owner_table
     */
    Optional<Owner> getOwnerByDriverLicense(String driverLicense);
}


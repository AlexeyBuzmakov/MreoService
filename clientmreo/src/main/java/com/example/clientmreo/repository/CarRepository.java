package com.example.clientmreo.repository;

import com.example.clientmreo.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity, Long> {
    /**
     * Метод возвращает CarEntity по vin_number из car_table
     */
    CarEntity getCarEntityByVinNumber(String vinNumber);

    /**
     * Методв обновляет запись в таблие car_table по входящим аргументам
     */
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE car_table SET owner_id=:id WHERE vin_number=:vinNumber")
    void updateCarTable(Long id, String vinNumber);
}

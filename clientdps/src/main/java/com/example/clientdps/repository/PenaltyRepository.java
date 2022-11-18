package com.example.clientdps.repository;

import com.example.clientdps.entity.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PenaltyRepository extends JpaRepository<Penalty, Long> {
    /**
     * Метод возвращает список Penalty по number_car из таблицы penalty_table
     */
    List<Penalty> getPenaltyEntitiesByNumber(String numberCar);
}

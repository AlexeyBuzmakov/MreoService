package com.example.clientdps.repository;

import com.example.clientdps.entity.PenaltyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PenaltyRepository extends JpaRepository<PenaltyEntity, Long> {
    /**
     * Метод возвращает список PenaltyEntity по number_car из таблицы penalty_table
     */
    List<PenaltyEntity> getPenaltyEntitiesByNumber(String number);
}

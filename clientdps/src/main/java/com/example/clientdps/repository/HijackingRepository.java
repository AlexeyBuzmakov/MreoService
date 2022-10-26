package com.example.clientdps.repository;

import com.example.clientdps.entity.HijackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HijackingRepository extends JpaRepository<HijackingEntity, Long> {
    /**
     * Метод возвращает HijackingEntity по vin_number из таблицы hijacking_table
     */
    HijackingEntity getHijackingEntityByVinNumber(String vinNumber);
}

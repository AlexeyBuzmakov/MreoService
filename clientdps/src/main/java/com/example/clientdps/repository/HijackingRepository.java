package com.example.clientdps.repository;

import com.example.clientdps.entity.Hijacking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HijackingRepository extends JpaRepository<Hijacking, Long> {
    /**
     * Метод возвращает Hijacking по vin_number из таблицы hijacking_table
     */
    Optional<Hijacking> getHijackingEntityByVinNumber(String vinNumber);
}

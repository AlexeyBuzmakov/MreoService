package com.example.clientdps.service.impl;

import com.example.clientdps.repository.PenaltyRepository;
import com.example.clientdps.service.PenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PenaltyServiceImpl implements PenaltyService {
    private final PenaltyRepository penaltyRepository;

    /**
     * Метод проверяет авто на наличие штрафов по информаии в базе данных по штрафам(penalty_table)
     */
    @Override
    public boolean checkPenalty(String numberCar) {
        return penaltyRepository.getPenaltyEntitiesByNumber(numberCar).isEmpty();
    }
}

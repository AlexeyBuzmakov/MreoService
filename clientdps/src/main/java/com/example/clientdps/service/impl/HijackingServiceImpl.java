package com.example.clientdps.service.impl;

import com.example.clientdps.repository.HijackingRepository;
import com.example.clientdps.service.HijackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HijackingServiceImpl implements HijackingService {
    private final HijackingRepository hijackingRepository;

    /**
     * Метод проверяет авто на угон по информаии в базе данных по угонам(hijacking_table)
     */
    @Override
    public boolean checkHijacking(String vinNumber) {
        if (hijackingRepository.getHijackingEntityByVinNumber(vinNumber).isPresent()) {
            return hijackingRepository.getHijackingEntityByVinNumber(vinNumber).get().getDateFind() != null;
        }
        return true;
    }
}

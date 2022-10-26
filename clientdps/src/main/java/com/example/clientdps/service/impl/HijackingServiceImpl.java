package com.example.clientdps.service.impl;

import com.example.clientdps.dto.HijackingDto;
import com.example.clientdps.entity.HijackingEntity;
import com.example.clientdps.mapper.DpsMapper;
import com.example.clientdps.repository.HijackingRepository;
import com.example.clientdps.service.HijackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HijackingServiceImpl implements HijackingService {
    private final HijackingRepository hijackingRepository;
    private final DpsMapper dpsMapper;

    /**
     * Метод возвращает HijackingDto с использованием Repository и
     * Mapper для преобразования Entity в Dto
     */
    @Override
    public HijackingDto getHijackingDto(String number) {
        HijackingEntity hijackingEntity = hijackingRepository.getHijackingEntityByVinNumber(number);
        return dpsMapper.getHijackingDto(hijackingEntity);
    }
}

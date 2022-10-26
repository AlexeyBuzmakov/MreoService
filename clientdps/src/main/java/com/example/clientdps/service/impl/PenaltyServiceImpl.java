package com.example.clientdps.service.impl;

import com.example.clientdps.dto.PenaltyDto;
import com.example.clientdps.dto.TypePenaltyDto;
import com.example.clientdps.entity.PenaltyEntity;
import com.example.clientdps.mapper.DpsMapper;
import com.example.clientdps.repository.PenaltyRepository;
import com.example.clientdps.service.PenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PenaltyServiceImpl implements PenaltyService {
    private final PenaltyRepository penaltyRepository;
    private final DpsMapper dpsMapper;

    /**
     * Метод возвращает список PenaltyDto с использованием Repository и
     * Mapper для преобразования Entity в Dto
     */
    @Override
    public List<PenaltyDto> getPenaltiesDto(String number) {
        List<PenaltyDto>penaltyDtoList = new ArrayList<>();
        List<PenaltyEntity>penaltyEntityList = penaltyRepository.getPenaltyEntitiesByNumber(number);
        for(PenaltyEntity penaltyEntity : penaltyEntityList) {
            TypePenaltyDto typePenaltyDto = dpsMapper.getTypePenaltyDto(penaltyEntity.getTypePenaltyEntity());
            PenaltyDto penaltyDto = dpsMapper.getPenaltyDto(penaltyEntity);
            penaltyDto.setTypePenaltyDto(typePenaltyDto);
            penaltyDtoList.add(penaltyDto);
        }
        return penaltyDtoList;
    }
}

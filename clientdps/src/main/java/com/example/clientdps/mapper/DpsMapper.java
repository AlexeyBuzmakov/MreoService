package com.example.clientdps.mapper;

import com.example.clientdps.dto.PenaltyDto;
import com.example.clientdps.dto.HijackingDto;
import com.example.clientdps.dto.TypePenaltyDto;
import com.example.clientdps.entity.PenaltyEntity;
import com.example.clientdps.entity.HijackingEntity;
import com.example.clientdps.entity.TypePenaltyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DpsMapper {
    HijackingDto getHijackingDto(HijackingEntity hijackingEntity);
    PenaltyDto getPenaltyDto(PenaltyEntity penaltyEntity);
    TypePenaltyDto getTypePenaltyDto(TypePenaltyEntity typePenaltyEntity);
}

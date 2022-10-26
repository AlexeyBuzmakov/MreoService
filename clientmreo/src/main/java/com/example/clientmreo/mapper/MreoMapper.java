package com.example.clientmreo.mapper;

import com.example.clientmreo.dto.CarDto;
import com.example.clientmreo.dto.OwnerDto;
import com.example.clientmreo.entity.CarEntity;
import com.example.clientmreo.entity.OwnerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MreoMapper {
    OwnerEntity getOwnerEntity(OwnerDto ownerDto);

    CarEntity getCarEntity(CarDto carDto);

    OwnerDto getOwnerDto(OwnerEntity ownerEntity);
}

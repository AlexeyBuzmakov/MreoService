package com.example.clientmreo.mapper;

import com.example.clientmreo.dto.OwnerCarDto;
import com.example.clientmreo.entity.Car;
import com.example.clientmreo.entity.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MreoMapper {
    Owner getOwner(OwnerCarDto ownerCarDto);
    Car getCar(OwnerCarDto ownerCarDto);



}

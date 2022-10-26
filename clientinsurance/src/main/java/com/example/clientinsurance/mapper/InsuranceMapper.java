package com.example.clientinsurance.mapper;

import com.example.clientinsurance.dto.InsuranceDto;
import com.example.clientinsurance.entity.InsuranceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {

    InsuranceDto getClientDto(InsuranceEntity insuranceEntity);
}

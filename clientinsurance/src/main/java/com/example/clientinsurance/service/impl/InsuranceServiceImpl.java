package com.example.clientinsurance.service.impl;

import com.example.clientinsurance.dto.InsuranceDto;
import com.example.clientinsurance.entity.InsuranceEntity;
import com.example.clientinsurance.mapper.InsuranceMapper;
import com.example.clientinsurance.repository.InsuranceRepository;
import com.example.clientinsurance.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final InsuranceMapper insuranceMapper;

    /**Метод возвращает InsuranceDto c спользованием Repository и
     * Mapper для преобразования Entity в Dto
     */

    @Override
    public InsuranceDto getInsuranceDto(String number) {
        InsuranceEntity insuranceEntity = insuranceRepository.getClientEntityByNumberCar(number);
        return insuranceMapper.getClientDto(insuranceEntity);
    }
}

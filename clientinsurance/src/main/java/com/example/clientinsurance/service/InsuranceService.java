package com.example.clientinsurance.service;

import com.example.clientinsurance.dto.InsuranceDto;
import org.springframework.stereotype.Service;

@Service
public interface InsuranceService {
    InsuranceDto getInsuranceDto(String number);
}

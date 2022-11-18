package com.example.clientinsurance.service.impl;

import com.example.clientinsurance.repository.InsuranceRepository;
import com.example.clientinsurance.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceRepository insuranceRepository;

    /**
     * Метод проверяет авто на наличие страхования и просроченность(date_end)
     * по информаии в базе данных по страхованию(insurance_table)
     */
    @Override
    public boolean checkInsurance(String numberCar) {
        if(insuranceRepository.getInsuranceByNumberCar(numberCar).isPresent()) {
            return insuranceRepository.getInsuranceByNumberCar(numberCar).get().getDateEnd().isAfter(LocalDate.now());
        }
        return false;
    }
}

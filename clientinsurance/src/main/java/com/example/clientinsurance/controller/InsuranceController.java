package com.example.clientinsurance.controller;

import com.example.clientinsurance.dto.InsuranceDto;
import com.example.clientinsurance.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.clientinsurance.controller.Links.INSURANCE;
import static com.example.clientinsurance.controller.Links.INSURANCE_INFO;

@RestController
@RequestMapping(INSURANCE)
@RequiredArgsConstructor
public class InsuranceController {
    private final InsuranceService insuranceService;

    /**
     * Метод возвращает InsuranceDto c использованием сервисного слоя InsuranceService
     */
    @GetMapping(INSURANCE_INFO)
    public @ResponseBody InsuranceDto getInfoInsurance(@RequestParam String number) {
        return insuranceService.getInsuranceDto(number);
    }
}

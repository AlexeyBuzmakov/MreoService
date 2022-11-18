package com.example.clientinsurance.controller;

import com.example.clientinsurance.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance")
@RequiredArgsConstructor
public class InsuranceController {
    private final InsuranceService insuranceService;

    /**
     * Метод возвращает статус возможности постановки на учёт
     * ok() - авто прошло проверку
     * badRequest() - авто не прошло проверку
     */
    @GetMapping("/get-info-insurance/{numberCar}")
    public ResponseEntity<?> getInfoInsurance(@PathVariable String numberCar) {
        if(insuranceService.checkInsurance(numberCar)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}

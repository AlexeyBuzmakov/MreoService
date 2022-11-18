package com.example.clientdps.controller;

import com.example.clientdps.service.HijackingService;
import com.example.clientdps.service.PenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dps")
@RequiredArgsConstructor
public class DpsController {
    private final PenaltyService penaltyService;
    private final HijackingService hijackingService;

    /**
     * Метод возвращает статус возможности постановки на учёт
     * ok() - авто прошло проверку
     * badRequest() - авто не прошло проверку
     */
    @GetMapping("/get-info-hijacking/{vinNumber}")
    public ResponseEntity<?> getInfoHijacking(@PathVariable String vinNumber) {
        if(hijackingService.checkHijacking(vinNumber)) {
            return ResponseEntity.ok().build();
        }
            return ResponseEntity.badRequest().build();
    }

    /**
     * Метод возвращает статус возможности постановки на учёт
     * ok() - авто прошло проверку
     * badRequest() - авто не прошло проверку
     */
    @GetMapping("/get-info-penalty/{numberCar}")
    public ResponseEntity<?> getInfoPenalty(@PathVariable String numberCar) {
        if(penaltyService.checkPenalty(numberCar)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}

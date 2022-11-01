package com.example.clientmreo.controller;

import com.example.clientmreo.dto.RequestDto;
import com.example.clientmreo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.example.clientmreo.controller.Links.MREO;
import static com.example.clientmreo.controller.Links.REGISTRATION;

@RestController
@RequestMapping(MREO)
@RequiredArgsConstructor
public class MreoController {
    private final CarService carService;
    private final OwnerService ownerService;
    private final HijackingService hijackingService;
    private final PenaltyService penaltyService;
    private final InsuranceService insuranceService;

    /**
     * Метод проверяет по входящим аргументам авто на наличие штрафов: таблица penalty_table,
     * наличие страхования и её просроченность: таблица-insurance_table, колонка-date_end
     * нахождение авто в угоне и дату возврата: таблица-hijacking_table, колонка-date_find
     * В случае успешной проверки происходит добавление или обновление данных в таблицах
     * car_table и owner_table
     */
    @PostMapping(REGISTRATION)
    public ResponseEntity<?> registration(@RequestBody RequestDto requestDto) {
        if (!penaltyService.checkPenalty(requestDto.getNumber())
                || !insuranceService.checkInsurance(requestDto.getNumber())
                || !hijackingService.checkHijacking(requestDto.getVinNumber()))
            return ResponseEntity.badRequest().build();
        ownerService.updateOwnerTable(requestDto);
        carService.updateCarTable(requestDto, ownerService.getIdOwner(requestDto.getDriverLicense()));
        return ResponseEntity.ok().build();
    }
}


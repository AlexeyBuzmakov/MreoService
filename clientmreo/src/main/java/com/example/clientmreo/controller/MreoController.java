package com.example.clientmreo.controller;

import com.example.clientmreo.dto.OwnerCarDto;
import com.example.clientmreo.service.MreoService;
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
    private final MreoService mreoService;

    /**
     * Метод проверяет по входящим аргументам авто на наличие штрафов: таблица penalty_table,
     * наличие страхования и её просроченность: таблица-insurance_table, колонка-date_end
     * нахождение авто в угоне и дату возврата: таблица-hijacking_table, колонка-date_find
     * В случае успешной проверки происходит добавление или обновление данных в таблицах
     * car_table и owner_table
     */
    @PostMapping(REGISTRATION)
    public ResponseEntity<?> registration(@RequestBody OwnerCarDto ownerCarDto) {
        if (mreoService.checkPenaltyHijackingInsurance(ownerCarDto))
            return ResponseEntity.badRequest().build();
        mreoService.updateOwnerCar(ownerCarDto);
        return ResponseEntity.ok().build();
    }
}


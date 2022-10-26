package com.example.clientmreo.controller;

import com.example.clientmreo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping(REGISTRATION)
    public String registration(@RequestParam String name, String patronymic, String surname, String driverLicense, String brand, String model, int yearIssue, String vinNumber, String number) {
        if (!hijackingService.checkHijacking(vinNumber))
            return "Невозможно поставить авто на учёт так как оно числится в угоне";
        if (!penaltyService.checkPenalty(number))
            return "Невозможно поставить авто на учёт так как имеются неоплаченные штрафы";
        if (!insuranceService.checkInsurance(number))
            return "Невозможно поставить авто на учёт так как отсутствует страхование";
        ownerService.updateOwnerTable(name, patronymic, surname, driverLicense);
        carService.updateCarTable(brand, model, yearIssue, vinNumber, number, ownerService.getOwnerDto(driverLicense), ownerService.getIdOwner(driverLicense));
        return "Авто поставлено на учёт";
    }
}


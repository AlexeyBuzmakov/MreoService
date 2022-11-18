package com.example.clientmreo.service.impl;

import com.example.clientmreo.dto.OwnerCarDto;
import com.example.clientmreo.feign.Feign;
import com.example.clientmreo.service.CarService;
import com.example.clientmreo.service.MreoService;
import com.example.clientmreo.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MreoServiceImpl implements MreoService {
    private final Feign feign;
    private final CarService carService;
    private final OwnerService ownerService;

    /**
     * В случае успешной проверки на угон, страхование и штрафы
     * происходит добавление или обновление данных в таблицах
     * car_table и owner_table
     */
    @Override
    public boolean registration(OwnerCarDto ownerCarDto) {
       if (feign.getInfoPenalty(ownerCarDto.getNumber()).getStatusCode().is4xxClientError()
                || feign.getInfoHijacking(ownerCarDto.getVinNumber()).getStatusCode().is4xxClientError()
                || feign.getInfoInsurance(ownerCarDto.getNumber()).getStatusCode().is4xxClientError()) {
            return false;
        }
        ownerService.updateOwner(ownerCarDto);
        carService.updateCar(ownerCarDto);
        return true;
    }
}

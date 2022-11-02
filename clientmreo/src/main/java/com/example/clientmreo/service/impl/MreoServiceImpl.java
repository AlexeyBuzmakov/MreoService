package com.example.clientmreo.service.impl;

import com.example.clientmreo.dto.OwnerCarDto;
import com.example.clientmreo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MreoServiceImpl implements MreoService {
    private final HijackingService hijackingService;
    private final PenaltyService penaltyService;
    private final InsuranceService insuranceService;
    private final CarService carService;
    private final OwnerService ownerService;

    @Override
    public boolean checkPenaltyHijackingInsurance(OwnerCarDto ownerCarDto) {
        return !penaltyService.checkPenalty(ownerCarDto.getNumber())
                || !insuranceService.checkInsurance(ownerCarDto.getNumber())
                || !hijackingService.checkHijacking(ownerCarDto.getVinNumber());
    }

    @Override
    public void updateOwnerCar(OwnerCarDto ownerCarDto) {
        ownerService.updateOwnerTable(ownerCarDto);
        carService.updateCarTable(ownerCarDto, ownerService.getIdOwner(ownerCarDto.getDriverLicense()));
    }
}

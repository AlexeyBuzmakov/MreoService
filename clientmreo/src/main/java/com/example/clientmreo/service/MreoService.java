package com.example.clientmreo.service;

import com.example.clientmreo.dto.OwnerCarDto;
import org.springframework.stereotype.Service;

@Service
public interface MreoService {
    boolean checkPenaltyHijackingInsurance(OwnerCarDto ownerCarDto);

    void updateOwnerCar(OwnerCarDto ownerCarDto);
}

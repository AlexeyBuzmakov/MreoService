package com.example.clientmreo.service;

import com.example.clientmreo.dto.OwnerCarDto;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    void updateCarTable(OwnerCarDto ownerCarDto, Long ownerId);
}

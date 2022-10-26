package com.example.clientmreo.service;

import com.example.clientmreo.dto.OwnerDto;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    void updateCarTable(String brand, String model, int yearIssue, String vinNumber, String number, OwnerDto ownerDto, Long ownerId);
}

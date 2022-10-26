package com.example.clientmreo.service;

import com.example.clientmreo.dto.OwnerDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
    void updateOwnerTable(String name, String patronymic, String surname, String driverLicense);
    Long getIdOwner(String driverLicense);
    OwnerDto getOwnerDto(String driverLicense);
}

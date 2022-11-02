package com.example.clientmreo.service;

import com.example.clientmreo.dto.OwnerCarDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
    void updateOwnerTable(OwnerCarDto ownerCarDto);
    Long getIdOwner(String driverLicense);
}

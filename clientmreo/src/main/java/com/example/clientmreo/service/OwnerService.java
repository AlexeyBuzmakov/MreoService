package com.example.clientmreo.service;

import com.example.clientmreo.dto.OwnerDto;
import com.example.clientmreo.dto.RequestDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
    void updateOwnerTable(RequestDto requestDto);
    Long getIdOwner(String driverLicense);
}

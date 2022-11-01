package com.example.clientmreo.service;

import com.example.clientmreo.dto.CarDto;
import com.example.clientmreo.dto.OwnerDto;
import com.example.clientmreo.dto.RequestDto;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    void updateCarTable(RequestDto requestDto, Long ownerId);
}

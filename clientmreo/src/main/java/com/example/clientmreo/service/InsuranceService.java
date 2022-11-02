package com.example.clientmreo.service;

import org.springframework.stereotype.Service;

@Service
public interface InsuranceService {
    boolean checkInsurance(String number);
}

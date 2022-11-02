package com.example.clientmreo.service;

import org.springframework.stereotype.Service;

@Service
public interface PenaltyService {
    boolean checkPenalty(String number);
}

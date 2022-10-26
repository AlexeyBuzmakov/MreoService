package com.example.clientmreo.service;

import org.springframework.stereotype.Service;

@Service
public interface HijackingService {
    boolean checkHijacking(String vinNumber);
}

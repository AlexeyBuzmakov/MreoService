package com.example.clientdps.service;

import org.springframework.stereotype.Service;

@Service
public interface HijackingService {
    boolean checkHijacking(String number);
}

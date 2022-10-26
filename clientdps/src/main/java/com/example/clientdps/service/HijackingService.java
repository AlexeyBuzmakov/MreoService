package com.example.clientdps.service;

import com.example.clientdps.dto.HijackingDto;
import org.springframework.stereotype.Service;

@Service
public interface HijackingService {
    HijackingDto getHijackingDto(String number);
}

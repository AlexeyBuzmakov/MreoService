package com.example.clientdps.service;

import com.example.clientdps.dto.PenaltyDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PenaltyService {
    List<PenaltyDto>getPenaltiesDto(String number);
}

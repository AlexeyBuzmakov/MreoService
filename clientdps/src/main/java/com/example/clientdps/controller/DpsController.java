package com.example.clientdps.controller;

import com.example.clientdps.dto.HijackingDto;
import com.example.clientdps.dto.PenaltyDto;
import com.example.clientdps.service.HijackingService;
import com.example.clientdps.service.PenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.example.clientdps.controller.Links.*;

@RestController
@RequestMapping(DPS)
@RequiredArgsConstructor
public class DpsController {
    private final PenaltyService penaltyService;
    private final HijackingService hijackingService;

    /**
     * Метод возвращает HijackingDto с использованием метода сервисного слоя HijackingService
     */
    @GetMapping(HIJACKING)
    public @ResponseBody HijackingDto getInfoHijacking(@RequestParam String number) {
        return hijackingService.getHijackingDto(number);
    }

    /**
     * Метод возвращает PenaltyDto c использованием сервисного слоя PenaltyService
     */
    @GetMapping(PENALTY)
    public @ResponseBody List<PenaltyDto> getInfoPenalty(@RequestParam String number) {
        return penaltyService.getPenaltiesDto(number);
    }
}

package com.example.clientdps.controller;

import com.example.clientdps.dto.HijackingDto;
import com.example.clientdps.dto.PenaltyDto;
import com.example.clientdps.dto.TypePenaltyDto;
import com.example.clientdps.service.HijackingService;
import com.example.clientdps.service.PenaltyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static com.example.clientdps.controller.Links.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(DpsController.class)
class DpsControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    HijackingService hijackingService;
    @MockBean
    PenaltyService penaltyService;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getInfoHijacking_returnHijackingDto_whenSearchSuccess() throws Exception {
        HijackingDto hijackingDto = new HijackingDto("65YHG872TGR", LocalDate.now(), LocalDate.now());
        when(hijackingService.getHijackingDto(hijackingDto.getVinNumber()))
                .thenReturn(hijackingDto);

        mockMvc.perform(get(DPS + HIJACKING + "?vinNumber=" + hijackingDto.getVinNumber()))
                .andExpect(jsonPath("$.vinNumber").value(hijackingDto.getVinNumber()))
                .andExpect(jsonPath("$.dateHijacking").exists())
                .andExpect(jsonPath("$.dateFind").exists());
    }

    @Test
    void getInfoHijacking_returnNull_whenSearchUnsuccessful() throws Exception {
        HijackingDto hijackingDto = new HijackingDto("65YHG872TG", LocalDate.now(), LocalDate.now());
        when(hijackingService.getHijackingDto(hijackingDto.getVinNumber()))
                .thenReturn(null);

        mockMvc.perform(get(DPS + HIJACKING + "?vinNumber=" + hijackingDto.getVinNumber()))
                .andExpect(jsonPath("$.vinNumber").doesNotExist())
                .andExpect(jsonPath("$.dateHijacking").doesNotExist())
                .andExpect(jsonPath("$.dateFind").doesNotExist());
    }

    @Test
    void getInfoPenalty_returnPenaltyDto_whenSearchSuccess() throws Exception{
        PenaltyDto penaltyDto = new PenaltyDto("65YHG87", LocalDate.now(), new TypePenaltyDto());
        when(penaltyService.getPenaltiesDto(penaltyDto.getNumber()))
                .thenReturn(List.of(penaltyDto));

        mockMvc.perform(get(DPS + PENALTY + "?number=" + penaltyDto.getNumber()))
                .andExpect(jsonPath("$[0].number").value(penaltyDto.getNumber()))
                .andExpect(jsonPath("$[0].datePenalty").exists())
                .andExpect(jsonPath("$[0].typePenaltyDto").exists());
    }

    @Test
    void getInfoPenalty_returnEmptyList_whenSearchUnsuccessful() throws Exception{
        PenaltyDto penaltyDto = new PenaltyDto("65YHG87", LocalDate.now(), new TypePenaltyDto());
        when(penaltyService.getPenaltiesDto(penaltyDto.getNumber()))
                .thenReturn(List.of());

        mockMvc.perform(get(DPS + PENALTY + "?number=" + penaltyDto.getNumber()))
                .andExpect(jsonPath("$").isEmpty());
    }
}
package com.example.clientmreo.controller;

import com.example.clientmreo.dto.OwnerCarDto;
import com.example.clientmreo.service.MreoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.clientmreo.controller.Links.MREO;
import static com.example.clientmreo.controller.Links.REGISTRATION;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MreoController.class)
class MreoControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    MreoService mreoService;

    @Test
    void registration_statusOk_whenCarRegistered() throws Exception {
        OwnerCarDto ownerCarDto = new OwnerCarDto("Alexey", "Vitalevich", "Buzmakov", "HFYHF8392", "Toyota", "Crown", 1978, "65YHG872TGR", "T791OH");
        when(mreoService.registration(ownerCarDto))
                .thenReturn(true);

        mockMvc.perform(post(MREO + REGISTRATION)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(ownerCarDto)))
                .andExpect(status().isOk());
    }

    @Test
    void registration_statusBadRequest_whenCarUnregistered() throws Exception {
        OwnerCarDto ownerCarDto = new OwnerCarDto("Alexey", "Vitalevich", "Buzmakov", "HFYHF8392", "Toyota", "Crown", 1978, "65YHG872TGR", "T791O");
        when(mreoService.registration(ownerCarDto))
                .thenReturn(false);

        mockMvc.perform(post(MREO + REGISTRATION)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(ownerCarDto)))
                .andExpect(status().isBadRequest());
    }
}
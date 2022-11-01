package com.example.clientmreo.controller;

import com.example.clientmreo.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(MreoController.class)
class MreoControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    CarService carService;
    @MockBean
    OwnerService ownerService;
    @MockBean
    HijackingService hijackingService;
    @MockBean
    PenaltyService penaltyService;
    @MockBean
    InsuranceService insuranceService;

    @Test
    void registration() {

    }
}
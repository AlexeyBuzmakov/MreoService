package com.example.clientinsurance.controller;

import com.example.clientinsurance.dto.InsuranceDto;
import com.example.clientinsurance.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.time.LocalDate;

import static com.example.clientinsurance.controller.Links.INSURANCE;
import static com.example.clientinsurance.controller.Links.INSURANCE_INFO;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(InsuranceController.class)
class InsuranceControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    InsuranceService insuranceService;


    @Test
    void getInfoInsurance_returnInsuranceDto_whenSearchSuccess() throws Exception {
        InsuranceDto insuranceDto = new InsuranceDto("UJhfu", LocalDate.now(), LocalDate.now(), "7YHG90");
        when(insuranceService.getInsuranceDto(insuranceDto.getNumberCar()))
                .thenReturn(insuranceDto);

        mockMvc.perform(get(INSURANCE + INSURANCE_INFO + "?number=" + insuranceDto.getNumberCar()))
                .andExpect(jsonPath("$.number").value(insuranceDto.getNumber()))
                .andExpect(jsonPath("$.dateStart").exists())
                .andExpect(jsonPath("$.dateEnd").exists())
                .andExpect(jsonPath("$.numberCar").value(insuranceDto.getNumberCar()));
    }

    @Test
    void getInfoInsurance_returnNull_whenSearchUnsuccessful() throws Exception {
        InsuranceDto insuranceDto = new InsuranceDto("UJhfu", LocalDate.now(), LocalDate.now(), "7YHG90");
        when(insuranceService.getInsuranceDto(insuranceDto.getNumberCar()))
                .thenReturn(null);

        mockMvc.perform(get(INSURANCE + INSURANCE_INFO + "?number=" + insuranceDto.getNumberCar()))
                .andExpect(jsonPath("$.number").doesNotExist())
                .andExpect(jsonPath("$.dateStart").doesNotExist())
                .andExpect(jsonPath("$.dateEnd").doesNotExist())
                .andExpect(jsonPath("$.numberCar").doesNotExist());
    }
}
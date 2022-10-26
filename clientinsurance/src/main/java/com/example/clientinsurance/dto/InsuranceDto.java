package com.example.clientinsurance.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InsuranceDto {
    private String number;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String numberCar;
}

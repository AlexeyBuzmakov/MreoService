package com.example.clientmreo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDto {
    private String brand;
    private String model;
    private Integer yearIssue;
    private String vinNumber;
    private String number;
    private OwnerDto ownerDto;
}

package com.example.clientmreo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HijackingDto {
    private String vinNumber;
    private LocalDate dateHijacking;
    private LocalDate dateFind;
}

package com.example.clientdps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "hijacking")
public class Hijacking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hijacking_id")
    private Long id;

    @Column(name = "vin_number")
    private String vinNumber;

    @Column(name = "date_hijacking")
    private LocalDate dateHijacking;

    @Column(name = "date_find")
    private LocalDate dateFind;
}

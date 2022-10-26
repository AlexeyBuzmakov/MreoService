package com.example.clientdps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "hijacking_table")
public class HijackingEntity {
    @Id
    @SequenceGenerator(name="hijacking_tableSequence", sequenceName="hijacking_table_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="hijacking_tableSequence")
    @Column(name = "hijacking_id", nullable = false)
    private Long id;

    @Column(name = "vin_number")
    private String vinNumber;

    @Column(name = "date_hijacking")
    private LocalDate dateHijacking;

    @Column(name = "date_find")
    private LocalDate dateFind;
}

package com.example.clientinsurance.entity;

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
@Table(name = "insurance_table")
public class InsuranceEntity {
    @Id
    @SequenceGenerator(name="insurance_tableSequence", sequenceName="insurance_table_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="insurance_tableSequence")
    @Column(name = "client_id", nullable = false)
    private Long id;

    @Column(name = "number_insurance")
    private String number;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "number_car")
    private String numberCar;
}

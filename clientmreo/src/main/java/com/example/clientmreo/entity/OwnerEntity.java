package com.example.clientmreo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "owner_table")
public class OwnerEntity {
    @Id
    @SequenceGenerator(name = "owner_tableSequence", sequenceName = "owner_table_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_tableSequence")
    @Column(name = "owner_id", nullable = false)
    private Long id;

    @Column(name = "owner_name")
    private String name;

    @Column(name = "owner_patronymic")
    private String patronymic;

    @Column(name = "owner_surname")
    private String surname;

    @Column(name = "driver_license")
    private String driverLicense;
}

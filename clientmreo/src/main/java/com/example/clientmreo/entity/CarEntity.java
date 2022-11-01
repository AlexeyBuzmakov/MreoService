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
@Table(name = "car_table")
public class CarEntity {
    @Id
    @SequenceGenerator(name="car_tableSequence", sequenceName="car_table_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="car_tableSequence")
    @Column(name = "car_id", nullable = false)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year_issue")
    private Integer yearIssue;

    @Column(name = "vin_number")
    private String vinNumber;

   @Column(name = "number_car")
   private String number;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OwnerEntity ownerEntity;
}

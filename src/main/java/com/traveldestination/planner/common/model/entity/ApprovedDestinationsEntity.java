package com.traveldestination.planner.common.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "approved_destination")
@Builder
public class ApprovedDestinationsEntity {
    @Id
    @Column(nullable = false, unique = true)
    private String country;
    @Column(name = "capital")
    private String capital;
    @Column(name = "region")
    private String region;
    @Column(name = "population")
    private Long population;
    @Column(name = "currency")
    private String currency;
    @Column(name = "flag")
    private String flag;
}
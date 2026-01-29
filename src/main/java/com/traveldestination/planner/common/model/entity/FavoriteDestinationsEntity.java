package com.traveldestination.planner.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favorite_destinations")
@IdClass(FavoriteDestinationsId.class)
public class FavoriteDestinationsEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private UserEntity user;

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

package com.traveldestination.planner.common.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavoriteDestinationsId implements Serializable {
    private Long userId;
    private String country;
}

package com.example.PhysioCenter.domain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class DatePhysioId implements Serializable {
    private Long physioId;
    private Long dateId;
}

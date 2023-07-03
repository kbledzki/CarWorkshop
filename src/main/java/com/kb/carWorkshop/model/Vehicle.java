package com.kb.carWorkshop.model;

import com.kb.carWorkshop.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    public static final String TABLE_NAME = "vehicle";
    private UUID id;
    private String name;
    private String registrationNumber;
    private boolean isFixed;
    private Color color;
    private int productionDate;

}

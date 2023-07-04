package com.kb.carWorkshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVehicleDto {
    private String name;
    private String registrationNumber;
    private boolean isFixed;
    private Color color;
    private int productionDate;
}

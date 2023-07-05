package com.kb.carWorkshop.dto;

import com.kb.carWorkshop.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVehicleDto {
    private String name;
    private String registrationNumber;
    private boolean isFixed;
    private Color color;
    private int productionDate;
    private String createdAt;
    private String updatedAt;
}

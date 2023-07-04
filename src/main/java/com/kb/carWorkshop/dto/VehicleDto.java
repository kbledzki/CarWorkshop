package com.kb.carWorkshop.dto;

import com.kb.carWorkshop.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

    private UUID id;
    private String name;
    private String registrationNumber;
    private boolean isFixed;
    private Color color;
    private int productionDate;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public String getCreatedAt() {
        return createdAt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT));
    }

    public String getUpdatedAt() {
        return updatedAt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT));
    }
}
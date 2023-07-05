package com.kb.carWorkshop.model;

import com.kb.carWorkshop.enums.Color;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = Vehicle.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    public static final String TABLE_NAME = "vehicle";
    public static final String COLUMN_PREFIX = "v_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = COLUMN_PREFIX + "name", nullable = false)
    private String name;

    @Column(name = COLUMN_PREFIX + "registrationNumber", nullable = false)
    private String registrationNumber;

    @Column(name = COLUMN_PREFIX + "isFixed")
    private boolean isFixed;

    @Column(name = COLUMN_PREFIX + "color")
    private Color color;

    @Column(name = COLUMN_PREFIX + "productionDate")
    private int productionDate;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;
}

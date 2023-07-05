package com.kb.carWorkshop.service;

import com.kb.carWorkshop.dto.CreateVehicleDto;
import com.kb.carWorkshop.dto.VehicleDto;

import java.util.List;
import java.util.UUID;

public interface VehicleServiceInterface {
    CreateVehicleDto saveVehicle(CreateVehicleDto createVehicleDto);
    List<VehicleDto> getAllVehicles();
    VehicleDto getVehicleById(Long id);
    List<VehicleDto> findFixedVehicles();
    List<VehicleDto> findNotFixedVehicles();
}

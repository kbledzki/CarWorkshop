package com.kb.carWorkshop.repository;

import com.kb.carWorkshop.model.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.UUID;

public class VehicleRepository extends JpaRepository <Vehicle, UUID> {


    @Override
    List<Vehicle> findVehicleByName(String name);

    @Override
    List<Vehicle> findVehicleByRegistrationNumberAndAndFixedIsTrue(String registrationNumber);

    @Override
    List<Vehicle> findVehicleByFixedIsTrue();

    @Override
    List <Vehicle> findVehicleByFixedIsFalse();

    @Transactional
    @Modifying
    @Query("update Vehicle v set v.isFixed = ?1 where v.id = ?2")
    void updateVehicle(boolean fixed, UUID id);




}

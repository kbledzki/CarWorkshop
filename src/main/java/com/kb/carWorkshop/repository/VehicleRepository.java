package com.kb.carWorkshop.repository;

import com.kb.carWorkshop.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public class VehicleRepository extends JpaRepository <Vehicle, UUID> {

}

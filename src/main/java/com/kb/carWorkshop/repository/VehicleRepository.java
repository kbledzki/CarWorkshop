package com.kb.carWorkshop.repository;

import com.kb.carWorkshop.model.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {


//    @Override
//    List<Vehicle> findVehicleByName(String name);
//
//    @Override
//    List<Vehicle> findVehicleByRegistrationNumberAndAndFixedIsTrue(String registrationNumber);
//
//    @Override
//    List<Vehicle> findVehicleByFixedIsTrue();
//
//    @Override
//    List<Vehicle> findVehicleByFixedIsFalse();

    @Query("select v from Vehicle v where v.name = ?1")
    List<Vehicle> findByName(String name);

    @Query("select v from Vehicle v where v.name = :name")
    List<Vehicle> findByName(String name, Sort sort);


    @Query("select v from Vehicle v where  v.registrationNumber like %?1% and v.isFixed = false")
    List<Vehicle> findByRegistrationNumberAndFixed(String registrationNumber);

    @Query("select v from Vehicle v where v.isFixed = true")
    List<Vehicle> findByFixed(Sort sort);

    @Query("select v from Vehicle v where v.isFixed = false")
    List<Vehicle> findNotFixed(Sort sort);

    @Transactional
    @Modifying
    @Query("update Vehicle v set v.isFixed = ?1 where v.id = ?2")
    void updateVehicle(boolean fixed, UUID id);
}

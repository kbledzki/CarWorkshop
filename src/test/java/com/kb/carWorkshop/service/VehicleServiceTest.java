package com.kb.carWorkshop.service;

import com.kb.carWorkshop.data.InitData;
import com.kb.carWorkshop.dto.CreateVehicleDto;
import com.kb.carWorkshop.dto.VehicleDto;
import com.kb.carWorkshop.model.Vehicle;
import com.kb.carWorkshop.repository.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.assertEquals;



@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    VehicleRepository vehicleRepositoryMock;

    VehicleService vehicleService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        vehicleService = new VehicleService(vehicleRepositoryMock, new ModelMapper());
    }

    @Test
    void shouldFindVehicleById() {
        //given
        List<Vehicle> vehicleToTest = InitData.vehicleList();
        when(vehicleRepositoryMock.findById(anyLong())).thenReturn(Optional.of(vehicleToTest.get(1)));
        //when
        VehicleDto vehicleById = vehicleService.getVehicleById(2L);
        //then
        verify(vehicleRepositoryMock, times(1)).findById(2L);
        assertEquals("ford", vehicleById.getName());

    }
    @Test
    void shouldFixVehicleById(){
        //given
        List<Vehicle> vehicleToTest = InitData.vehicleList();
        when(vehicleRepositoryMock.findById(anyLong())).thenReturn(Optional.of(vehicleToTest.get(1)));
        //when
        VehicleDto vehicleById = vehicleService.fixVehicleById(2L);
        //then
        verify(vehicleRepositoryMock, times(1)).findById(2L);
        assertEquals(true, vehicleById.isFixed());
    }

    @Test
    void shouldGetAllVehicles() {
        //given
        List<Vehicle> vehicleToTest = InitData.vehicleList();
        when(vehicleRepositoryMock.findAll()).thenReturn(vehicleToTest);
        //when
        List<VehicleDto> allVehicle = vehicleService.getAllVehicles();
        //then
        assertThat(allVehicle).hasSize(4);
    }
    @Test
    void findByRegistrationNumber() {
        List<Vehicle> vehicleToTest = InitData.vehicleList();
        when(vehicleRepositoryMock.findAll()).thenReturn(vehicleToTest);
        //when
        List<VehicleDto> allVehicle = vehicleService.getAllVehicles().stream().filter(v ->v.getRegistrationNumber().equals("GD22290")).collect(Collectors.toList());
        //then
        assertThat(allVehicle).hasSize(1);
    }
    @Test
    void shouldFindFixedVehicles() {
        //given
        List<Vehicle> vehicleToTest = InitData.vehicleList().stream().filter(vehicle -> vehicle.isFixed()).collect(Collectors.toList());
        when(vehicleRepositoryMock.findNotFixed(Sort.by(Sort.Direction.ASC, "createdAt"))).thenReturn(vehicleToTest);
        //when
        List<VehicleDto> resultListOfVehicle = vehicleService.findNotFixedVehicles();
        //then
        assertThat(resultListOfVehicle).hasSize(1);
    }

    @Test
    void shouldFindNotFixedVehicles() {
        //given
        List<Vehicle> vehicleToTest = InitData.vehicleList().stream().filter(vehicle -> !vehicle.isFixed()).collect(Collectors.toList());
        when(vehicleRepositoryMock.findNotFixed(Sort.by(Sort.Direction.ASC, "createdAt"))).thenReturn(vehicleToTest);
        //when
        List<VehicleDto> resultListOfVehicle = vehicleService.findNotFixedVehicles();
        //then
        assertThat(resultListOfVehicle).hasSize(3);
    }
    @Test
    void shouldSaveVehicle() {
        //given
        Vehicle vehicle = new Vehicle();
        when(vehicleRepositoryMock.save(vehicle)).thenReturn(vehicle);
        //when
        CreateVehicleDto savedVehicle = vehicleService.saveVehicle(new CreateVehicleDto());
        //then
        verify(vehicleRepositoryMock, times(1)).save(vehicle);
    }
}
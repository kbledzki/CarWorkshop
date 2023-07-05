package com.kb.carWorkshop.data;

import com.kb.carWorkshop.dto.VehicleDto;
import com.kb.carWorkshop.enums.Color;
import com.kb.carWorkshop.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class InitData {
    public static List<Vehicle> vehicleList() {
        Vehicle skoda = new Vehicle(1L, "skoda", "GD22290", false, Color.BLACK, 2010, "05/07/2023 13:35:05", "");
        Vehicle ford = new Vehicle(2L, "ford", "WA22234", false, Color.RED, 2015, "03/07/2023 13:20:05", "");
        Vehicle bmw = new Vehicle(3L, "bmw", "WA22222", false, Color.BLUE, 2018, "04/07/2023 13:20:05", "");
        Vehicle audi = new Vehicle(4L, "audi", "DA22233", true, Color.GREEN, 2020, "02/07/2023 14:20:05", "03/07/2023 14:20:05");
        return List.of(skoda, ford, bmw, audi);

    }
    public static List<VehicleDto> vehicleDtoList() {
        VehicleDto skoda = new VehicleDto(1L, "skoda", "GD22290", false, Color.BLACK, 2010, "05/07/2023 13:35:05", "");
        VehicleDto ford = new VehicleDto(2L, "ford", "WA22234", false, Color.RED, 2015, "03/07/2023 13:20:05", "");
        VehicleDto bmw = new VehicleDto(3L, "bmw", "WA22222", false, Color.BLUE, 2018, "04/07/2023 13:20:05", "");
        VehicleDto audi = new VehicleDto(4L, "audi", "DA22233", true, Color.GREEN, 2020, "02/07/2023 14:20:05", "03/07/2023 14:20:05");
        return List.of(skoda, ford, bmw, audi);
    }
}

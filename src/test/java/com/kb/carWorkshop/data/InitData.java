package com.kb.carWorkshop.data;

import com.kb.carWorkshop.enums.Color;
import com.kb.carWorkshop.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
class InitData {
    static Vehicle skoda = new Vehicle("11e87d90-36dd-48dd-850d-b158ddd8888d", "skoda","GD22290",false, Color.BLACK.getValue(),2010,"05/07/2023 13:35:05","");
    static Vehicle ford = new Vehicle("11e87d90-36dd-48dd-850d-b158ddd9999c", "ford","WA22234",false, Color.RED.getValue(),2015,"03/07/2023 13:20:05","");
    static Vehicle bmw = new Vehicle("11e87d90-44aa-48dd-850d-b158ddd9999c", "bmw","WA22222",false, Color.BLUE.getValue(),2018,"04/07/2023 13:20:05","");
    static Vehicle audi = new Vehicle("11e87d90-44aa-48dd-850d-b158ddd6666w", "audi","DA22233",true, Color.GREEN.getValue(),2020,"02/07/2023 14:20:05","03/07/2023 14:20:05");
    static List <Vehicle> vehicleList = List.of(skoda,ford,bmw,audi);
}

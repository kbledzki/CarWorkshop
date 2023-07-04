package com.kb.carWorkshop.controller;

import com.kb.carWorkshop.dto.CreateVehicleDto;
import com.kb.carWorkshop.dto.VehicleDto;
import com.kb.carWorkshop.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.UUID;

@Controller
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public String getVehiclesToFix(Model model) {
        model.addAttribute("vehiclesList", vehicleService.findNotFixedVehicles());
        return "vehicles";
    }

    @GetMapping("vehicles/fixed")
    public String getFixedVehicles(Model model) {
        model.addAttribute("fixedVehicles", vehicleService.findFixedVehicles());
        return "vehicles-fixed";
    }

    @GetMapping("vehicle/new")
    public String getNewVehicleForm(Model model) {
        model.addAttribute("vehicle", new CreateVehicleDto());
        return "new-vehicle-form";
    }

    @PostMapping("vehicle/new")
    public String createVehicle(@Valid @ModelAttribute("vehicle") CreateVehicleDto vehicle, Model model,
                                Errors errors) {
        if (errors.hasErrors()) {
            return "new-vehicle-form";
        }
        model.addAttribute("vehicle", vehicleService.saveVehicle(vehicle));
        return "redirect:/vehicles";
    }

    @GetMapping("vehicle/fixed")
    public String fixedVehiclesSearch() {
        return "vehicle-search";
    }

    @GetMapping("vehicle/fix/{id}")
    public String fixVehicleView(@PathVariable(value = "id") UUID id, Model model) {
        VehicleDto vehicleDto = vehicleService.fixVehicleById(id);
        if (vehicleDto == null) {
            return "not-found";
        }
        model.addAttribute("vehicle", vehicleDto);
        return "fixed-vehicle";
    }

    @GetMapping("vehicle/fix")
    public String getVehicleSearchView() {
        return "vehicle-search";
    }

    @GetMapping("vehicle/fix/search")
    public String getRegultOfSearch(@Param("registration") String registration, Model model) {
        model.addAttribute("vehiclesList", vehicleService.findByRegistrationNumber(registration));
        model.addAttribute("registration", registration);
        model.addAttribute("describtion", "Search for '" + registration + "' in registration plates:");
        model.addAttribute("tableDesc", "List of vehicles with registration plate including sign '" + registration + "' in it:");
        return "vehicle-search-result";
    }
}

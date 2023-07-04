package com.kb.carWorkshop.controller;

import com.kb.carWorkshop.dto.CreateVehicleDto;
import com.kb.carWorkshop.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @GetMapping("/vehicles")
    public String getVehiclesToFix(Model model){
        model.addAttribute("vehiclesList", vehicleService.findNotFixedVehicles());
        return "vehicles";
    }
    @GetMapping("vehicles/fixed")
    public String getFixedVehicles(Model model){
        model.addAttribute("fixedVehicles", vehicleService.findFixedVehicles());
        return "vehicles-fixed";
    }
    @GetMapping("vehicles/new")
    public String getNewVehicleForm(Model model){
        model.addAttribute("vehicle", new CreateVehicleDto());
        return "new-vehicle-form";
    }

    @PostMapping(value = "new")
    public String createVehicle(@Valid @ModelAttribute("vehicle") CreateVehicleDto vehicle, Model model,
                                Errors errors) {
        if (errors.hasErrors()) {
            return "new-vehicle-form";
        }
        model.addAttribute("vehicle", vehicleService.saveVehicle(vehicle));
        return "redirect:/vehicles";
    }
}

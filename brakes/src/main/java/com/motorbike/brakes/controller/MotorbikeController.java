package com.motorbike.brakes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honda.equiment.HondaAirCompressor;
import com.motorbike.brakes.service.MechanicService;

@RestController
public class MotorbikeController {

    private MechanicService engineMechanic;
    private MechanicService electricalMechanic;
    private HondaAirCompressor hondaAirCompressor;

    @Autowired
    public MotorbikeController(@Qualifier("engineMechanic") MechanicService engineMechanic, @Qualifier("electricalMechanic") MechanicService electricalMechanic,
            HondaAirCompressor hondaAirCompressor) {
        this.engineMechanic = engineMechanic;
        this.electricalMechanic = electricalMechanic;
        this.hondaAirCompressor = hondaAirCompressor;
    }

    @Value("${engine.name}")
    private String engineName;

    @Value("${electrical.name}")
    private String electricalName;

    @GetMapping("/api/brakes")
    public String checkBrakes() {
        return engineName + engineMechanic.getDailyTask();
    }

    @GetMapping("/api/electric")
    public String checkElectric() {
        return electricalName + electricalMechanic.getDailyTask();
    }

    @GetMapping("/api/compressor")
    public String pumTire() {
        return hondaAirCompressor.pumpTire();
    }
}

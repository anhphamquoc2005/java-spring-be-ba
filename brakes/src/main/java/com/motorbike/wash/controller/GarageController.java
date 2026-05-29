package com.motorbike.wash.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motorbike.wash.service.WashService;
import com.yamaha.hardware.YamahaBrakeTester;

@RestController
public class GarageController {
    
    private WashService standardWash;
    private WashService premiumWash;
    private YamahaBrakeTester yamahaBrakeTester;

    public GarageController(@Qualifier("standardWash") WashService standardWash, @Qualifier("premiumWash") WashService premiumWash, YamahaBrakeTester yamahaBrakeTester) {
        this.standardWash = standardWash;
        this.premiumWash = premiumWash;
        this.yamahaBrakeTester = yamahaBrakeTester;
    }

    @Value("${garage.name}")
    private String garageName;

    @Value("${garage.hotline}")
    private int garageHotline;

    @GetMapping("/api/info")
    public String getNameGarage() {
        return garageName + " " + garageHotline;
    }

    @GetMapping("/api/wash/standard")
    public String getStandardWash() {
        return standardWash.washMotorbike();
    }

    @GetMapping("/api/wash/premium")
    public String getPremiumWash() {
        return premiumWash.washMotorbike();
    }

    @GetMapping("/api/test-brake")
    public String getYamahaBrake() {
        return yamahaBrakeTester.runTest();
    }
}

package com.easports.data.service;

import org.springframework.stereotype.Component;

@Component
public class FitnessService implements CoachService{

    @Override
    public String getDailyDrill() {
        return "Chạy bền 100km và tập tạ.";
    }
    
}

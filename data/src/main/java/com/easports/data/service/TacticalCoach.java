package com.easports.data.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TacticalCoach implements CoachService{

    @Override
    public String getDailyDrill() {
        return "Tập kiểm soát bóng và ban bật trong không gian hẹp.";
    }
    
}

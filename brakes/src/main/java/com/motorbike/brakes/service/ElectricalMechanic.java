package com.motorbike.brakes.service;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ElectricalMechanic implements MechanicService{

    @PostConstruct
    public void prepareTools() {
        System.out.println("Đã chuẩn bị xong các thiết bị cần thiết...");
    }

    @Override
    public String getDailyTask() {
        return "Đang kiểm tra bugi và bình ắc quy...";
    }
    
}

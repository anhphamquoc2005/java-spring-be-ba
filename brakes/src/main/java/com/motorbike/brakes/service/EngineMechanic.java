package com.motorbike.brakes.service;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class EngineMechanic implements MechanicService{

    @PostConstruct
    public void prepareTools() {
        System.out.println("Đã chuẩn bị xong cờ lê và máy dập phanh!");
    }

    @Override
    public String getDailyTask() {
        return "Đang kiểm tra động cơ và thay nhớt...";
    }
    
}

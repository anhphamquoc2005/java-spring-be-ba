package com.motorbike.wash.service;

import org.springframework.stereotype.Component;

@Component
public class PremiumWash implements WashService{

    @Override
    public String washMotorbike() {
        return "Đang rửa bằng bọt tuyết và phủ nano...";
    }
    
}

package com.motorbike.wash.service;

import org.springframework.stereotype.Component;

@Component
public class StandardWash implements WashService{

    @Override
    public String washMotorbike() {
        return "Đang rửa xe bằng xà phòng thường...";
    }
}

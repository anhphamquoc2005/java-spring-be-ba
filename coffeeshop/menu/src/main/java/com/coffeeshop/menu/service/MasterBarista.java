package com.coffeeshop.menu.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MasterBarista implements BaristaService{

    @Override
    public String makeCoffee() {
        return "Cà phê được pha bởi Master Barista: Đậm đà, chuẩn vị!";
    }
    
}

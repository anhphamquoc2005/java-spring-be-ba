package com.motorbike.brakes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.honda.equiment.HondaAirCompressor;

@Configuration
public class GarageConfig {
    
    @Bean
    public HondaAirCompressor setuCompressor() {
        HondaAirCompressor compressor = new HondaAirCompressor();
        return compressor;
    }

}

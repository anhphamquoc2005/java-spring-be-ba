package com.motorbike.wash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yamaha.hardware.YamahaBrakeTester;

@Configuration
public class GarageConfig {
    
    @Bean
    public YamahaBrakeTester setupBrakeTester() {
        YamahaBrakeTester brakeTester = new YamahaBrakeTester();
        return brakeTester;
    }
}

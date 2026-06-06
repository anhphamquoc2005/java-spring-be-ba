package com.easports.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.easports.analyze.EASportAnalyzer;

@Configuration
public class CoachConfig{
    
    @Bean
    public EASportAnalyzer eaSportAnalyzer() {
        EASportAnalyzer analyzer = new EASportAnalyzer();
        return analyzer;
    }
}

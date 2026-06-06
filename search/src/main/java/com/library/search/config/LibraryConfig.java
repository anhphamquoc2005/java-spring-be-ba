package com.library.search.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hardware.scanner.BarcodeScanner;

@Configuration
public class LibraryConfig {

    @Bean
    public BarcodeScanner barcodeScanner() {
        BarcodeScanner scanner = new BarcodeScanner();
        return scanner;
    }
}

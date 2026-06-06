package com.library.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardware.scanner.BarcodeScanner;
import com.library.search.service.SearchService;

@RestController
public class LibraryController {

    @Value("${library.name}")
    private String libraryName;

    @Value("${library.time}")
    private String libraryTime;

    private SearchService titleSearch;
    private SearchService authorSearch;
    private BarcodeScanner barcodeScanner;

    @Autowired
    public LibraryController(@Qualifier("titleSearch") SearchService titleSearch, @Qualifier("authorSearch") SearchService authorSearch, BarcodeScanner barcodeScanner) {
        this.titleSearch = titleSearch;
        this.authorSearch = authorSearch;
        this.barcodeScanner = barcodeScanner;
    }

    @GetMapping("/api/library/info")
    public String getLibrary() {
        return "Thư viện: " + libraryName + ". Thời gian mở cửa: " + libraryTime;
    }

    @GetMapping("/api/library/search-title")
    public String searchTitle() {
        return titleSearch.searchBook();
    }

    @GetMapping("/api/library/search-author")
    public String searchAuthor() {
        return authorSearch.searchBook();
    }

    @GetMapping("/api/scan")
    public String scanBarcode() {
        return barcodeScanner.scan();
    }
}
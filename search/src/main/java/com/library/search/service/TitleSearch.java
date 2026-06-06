package com.library.search.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TitleSearch implements SearchService{

    @Override
    public String searchBook() {
        return "Đang tìm kiếm sách theo tựa đề...";
    }
}

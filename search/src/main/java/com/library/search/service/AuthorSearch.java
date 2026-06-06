package com.library.search.service;

import org.springframework.stereotype.Component;

@Component
public class AuthorSearch implements SearchService{

    @Override
    public String searchBook() {
        return "Đang tìm sách theo tên tác giả...";
    }
}

package com.graduation.management.service;

import org.springframework.stereotype.Component;

@Component
public class AiService implements MentorService{

    @Override
    public String getAdvice() {
        return "Hãy tự tay gõ code độc lập để nâng cao kỹ năng logic nhé!";
    }
    
}

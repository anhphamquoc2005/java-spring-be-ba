package com.graduation.management.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TeacherService implements MentorService{

    @Override
    public String getAdvice() {
        return "Hãy tập trung hoàn thiện kiến trúc Backend vững chắc trước khi làm Frontend!";
    }
    
}

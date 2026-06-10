package com.graduation.management;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.graduation.management.dao.ProjectDAO;
import com.graduation.management.entity.Project;
import com.graduation.management.service.MentorService;

@SpringBootApplication
public class ManagementApplication {

	@Value("${college.name}")
	private String collegeName;

	@Value("${graduation.year}")
	private String graduationYear;

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(
            ProjectDAO projectDAO,
            MentorService defaultMentor, // Nhờ có @Primary, Spring tự bơm TeacherLeNguyenKhanh vào đây
            @Qualifier("aiService") MentorService aiMentor) { // Bắt buộc lấy AiAssistant
            
        return runner -> {
            System.out.println("=============================================");
            System.out.println("Chào mừng đến với Hệ thống Quản lý Đồ án " + graduationYear + " của " + collegeName);
            System.out.println("--- LỜI KHUYÊN TỪ BAN HƯỚNG DẪN ---");
            System.out.println(defaultMentor.getAdvice());
            System.out.println(aiMentor.getAdvice());
            System.out.println("=============================================\n");

            // 1. Thêm 2 đồ án vào Database
            System.out.println("1. Đang khởi tạo và lưu đồ án...");
            Project p1 = new Project("Library Management Website", "React, Redux Toolkit & Firebase", "Đang làm");
            Project p2 = new Project("Communication Campaign Management", "React & Spring Boot", "Lên ý tưởng");
            projectDAO.save(p1);
            projectDAO.save(p2);
            
            // 2. Tìm đồ án 1 và cập nhật trạng thái
            System.out.println("2. Đang nộp báo cáo và cập nhật trạng thái đồ án 1...");
            Project targetProject = projectDAO.findById(1);
            if (targetProject != null) {
                targetProject.setStatus("Hoàn thành (Đã viết xong Chapter 5)");
                projectDAO.update(targetProject);
            }

            // 3. In toàn bộ danh sách đồ án để kiểm tra
            System.out.println("\n--- DANH SÁCH ĐỒ ÁN HIỆN TẠI ---");
            List<Project> projects = projectDAO.findAll();
            for (Project p : projects) {
                System.out.println("ID " + p.getId() + " | Tên: " + p.getNameProject() 
                                 + " | Công nghệ: " + p.getTechStack() 
                                 + " | Trạng thái: " + p.getStatus());
            }
        };
    }
}

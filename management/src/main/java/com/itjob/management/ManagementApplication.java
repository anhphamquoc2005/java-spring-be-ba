package com.itjob.management;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.itjob.management.dao.ItJobDAO;
import com.itjob.management.entity.ItJob;

@SpringBootApplication
public class ManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ItJobDAO itJobDAO) {
        return runner -> {
            testJobManagement(itJobDAO);
        };
    }

    private void testJobManagement(ItJobDAO itJobDAO) {
        System.out.println("--- BẮT ĐẦU TEST HỆ THỐNG QUẢN LÝ THỰC TẬP SINH ---");

        System.out.println("1. Đang tạo tin tuyển dụng...");
        ItJob job1 = new ItJob("ReactJS Intern", "Wistron", "Gò Vấp");
        ItJob job2 = new ItJob("Java Spring Boot Fresher", "IEG", "Quận 3");

        System.out.println("2. Đang lưu dữ liệu xuống MySQL...");
        itJobDAO.save(job1);
        itJobDAO.save(job2);
        System.out.println("=> Lưu thành công!");

        System.out.println("3. Đang truy xuất danh sách công việc từ Database...");
        List<ItJob> allJobs = itJobDAO.findAll();

        System.out.println("\n--- DANH SÁCH TIN TUYỂN DỤNG HIỆN CÓ ---");
        for (ItJob job : allJobs) {
            System.out.println("- Vị trí: " + job.getPosition() + 
                               " | Công ty: " + job.getCompany() + 
                               " | Khu vực: " + job.getDistrict());
        }
        System.out.println("-------------------------------------------------");
    }
}

package com.arsenal.management;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.arsenal.management.dao.PlayerDAO;
import com.arsenal.management.entity.Player;

@SpringBootApplication
public class ManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}

	@Bean
    public CommandLineRunner commandLineRunner(PlayerDAO playerDAO) {
        return runner -> {
            // Chúng ta sẽ gọi tuần tự các lệnh ở đây để test
            
            // 1. Thêm 2 cầu thủ mới vào sân (CREATE)
            System.out.println("Đang mua cầu thủ mới...");
            Player p1 = new Player("Bukayo Saka", "Tiền đạo cánh", 7);
            Player p2 = new Player("Martin Odegaard", "Tiền vệ trung tâm", 8);
            playerDAO.save(p1);
            playerDAO.save(p2);
            System.out.println("Đã lưu xong!");

            // 2. Tìm cầu thủ số 1 và đổi số áo (UPDATE)
            System.out.println("Đang cập nhật số áo...");
            Player targetPlayer = playerDAO.findById(1); // Giả sử Saka là ID số 1
            if (targetPlayer != null) {
                targetPlayer.setJerseyNumber(77); // Đổi số áo
                playerDAO.update(targetPlayer);
            }

            // 3. In ra danh sách toàn đội (READ ALL)
            System.out.println("--- DANH SÁCH ĐỘI HÌNH HIỆN TẠI ---");
            List<Player> team = playerDAO.findAll();
            for (Player p : team) {
                System.out.println(p.getName() + " - Vị trí: " + p.getPosition() + " - Số áo: " + p.getJerseyNumber());
            }
        };
    }
}

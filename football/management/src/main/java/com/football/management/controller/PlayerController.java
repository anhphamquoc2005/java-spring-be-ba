package com.football.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.management.dao.PlayerDAO;
import com.football.management.entity.Player;

@RequestMapping("/api/players")
@RestController
public class PlayerController {

    private PlayerDAO playerDAO;

    @Value("${name.club}")
    private String name_club;

    @Value("${nation.club}")
    private String nation;

    public PlayerController(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @GetMapping("/info")
    public String getInfo() {
        return "Chào mừng đến với " + name_club + " đại diện của " + nation;
    }

    @GetMapping
    public List<Player> getAllPlayer() {
        return playerDAO.findAll();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return playerDAO.findById(0);
    }

    @PostMapping("/add")
    public Player addPlayer(@RequestBody Player newPlayer) {
        newPlayer.setId(0);
        playerDAO.save(newPlayer);
        return newPlayer;
    }

    @PutMapping("/update/{id}")
    public String updatedPlayer(@PathVariable int id, @RequestBody Player updatePlayer) {
        Player existingPlayer = playerDAO.findById(id);
        if (existingPlayer == null) {
            return "Không tìm thấy cầu thủ có id: " + id;
        }

        existingPlayer.setName(updatePlayer.getName());
        existingPlayer.setPositon(updatePlayer.getPositon());
        existingPlayer.setOverallRating(updatePlayer.getOverallRating());

        playerDAO.update(existingPlayer);
        return "Cập nhật thông tin cầu thủ thành công!!!";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePlayer(@PathVariable int id) {
        Player temp = playerDAO.findById(id);
        if (temp == null) {
            return "Không tìm thấy cầu thủ có id: " + id;
        }
        playerDAO.deleteById(id);
        return "Đã xoá cầu thủ có id: " + id;
    }
}
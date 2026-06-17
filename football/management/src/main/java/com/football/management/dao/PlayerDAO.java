package com.football.management.dao;

import java.util.List;

import com.football.management.entity.Player;

public interface PlayerDAO {
    void save(Player player);
    Player findById(int id);
    void deleteById(int id);
    void update(Player player);
    List<Player> findAll();
}

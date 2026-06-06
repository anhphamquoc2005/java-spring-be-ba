package com.arsenal.management.dao;

import java.util.List;

import com.arsenal.management.entity.Player;

public interface PlayerDAO {
    void save(Player player);
    Player findById(int id);
    void update(Player player);
    void delete(int id);
    List<Player> findAll();
}

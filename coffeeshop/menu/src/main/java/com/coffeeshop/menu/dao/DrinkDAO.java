package com.coffeeshop.menu.dao;

import java.util.List;

import com.coffeeshop.menu.entity.Drink;

public interface DrinkDAO {
    void save(Drink drink);
    void delete(int id);
    void update(Drink drink);
    Drink findById(int id);
    List<Drink> findAll();
}

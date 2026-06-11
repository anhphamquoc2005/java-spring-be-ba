package com.coffeeshop.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.menu.dao.DrinkDAO;
import com.coffeeshop.menu.entity.Drink;
import com.coffeeshop.menu.service.BaristaService;

@RestController
@RequestMapping("/api")
public class DrinkController {
    
    private DrinkDAO drinkDAO;
    private BaristaService baristaService;

    @Value("${coffee.shop}")
    private String shopName;

    @Value("${address.shop}")
    private String shopAddress;

    @Autowired
    public DrinkController(DrinkDAO drinkDAO, BaristaService baristaService) {
        this.drinkDAO = drinkDAO;
        this.baristaService = baristaService;
    }

    @GetMapping("/info")
    public String getInfo() {
        return "Chào mừng đến với " + shopName + " (" + shopAddress + ") " + baristaService.makeCoffee();
    }

    @GetMapping("/drinks")
    public List<Drink> getMenu() {
        return drinkDAO.findAll();
    }

    @GetMapping("/drinks/{drinkId}")
    public Drink getDrink(@PathVariable int drinkId) {
        return drinkDAO.findById(drinkId);
    }

    @PostMapping("/drinks/add")
    public Drink addDrink(@RequestBody Drink newDrink) {
        newDrink.setId(0);
        drinkDAO.save(newDrink);
        return newDrink;
    }

    @PutMapping("/drinks")
    public Drink updateDrink(@RequestBody Drink updateDrink) {
        drinkDAO.update(updateDrink);
        return updateDrink;
    }

    @DeleteMapping("/drinks/{drinkId}")
    public String deleteDrink(@PathVariable int drinkId) {
        Drink temp = drinkDAO.findById(drinkId);
        if (temp == null) {
            return "Không tìm thấy món ID: " + drinkId;
        }
        drinkDAO.delete(drinkId);
        return "Đã xoá thành công món ID: " + drinkId;
    }
}

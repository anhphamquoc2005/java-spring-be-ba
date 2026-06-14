package com.jewelry.store.dao;

import java.util.List;

import com.jewelry.store.entity.Product;

public interface ProductDAO {
    void save(Product product);
    Product findById(int id);
    void delete(int id);
    void update(Product product);
    List<Product> findAll();
}
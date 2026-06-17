package com.sparepart.management.dao;

import java.util.List;

import com.sparepart.management.entity.SparePart;

public interface SparePartDAO {

    void save(SparePart sparePart);
    SparePart findById(int id);
    void update(SparePart sparePart);
    void delete(int id);
    List<SparePart> findAll();
}
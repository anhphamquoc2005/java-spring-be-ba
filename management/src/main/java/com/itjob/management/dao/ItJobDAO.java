package com.itjob.management.dao;

import java.util.List;

import com.itjob.management.entity.ItJob;

public interface ItJobDAO {
    void save(ItJob itJob);
    ItJob findById(int id);
    void update(ItJob itJob);
    void delete(int id);
    List<ItJob> findAll();
}

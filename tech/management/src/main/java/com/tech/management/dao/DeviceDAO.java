package com.tech.management.dao;

import java.util.List;

import com.tech.management.entity.Device;

public interface DeviceDAO {
    void save(Device device);
    Device findById(int id);
    void update(Device device);
    void delete(int id);
    List<Device> findAll();
}

package com.tech.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.management.dao.DeviceDAO;
import com.tech.management.entity.Device;

@RequestMapping("/api/techs")
@RestController
public class DeviceController {
    
    private DeviceDAO deviceDAO;

    @Autowired
    public DeviceController(DeviceDAO deviceDAO) {
        this.deviceDAO = deviceDAO;
    }

    @GetMapping
    public List<Device> getAll() {
        return deviceDAO.findAll();
    }

    @GetMapping("/{id}")
    public Device getById(@PathVariable int id) {
        return deviceDAO.findById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody Device newDevice) {
        newDevice.setId(0);
        deviceDAO.save(newDevice);
        return "Thêm mới thiết bị thành công!";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Device updateDevice) {
        Device existingDevice = deviceDAO.findById(id);
        if (existingDevice == null) {
            return "Không tìm thấy thiết bị có ID: " + id;
        }

        existingDevice.setDeviceName(updateDevice.getDeviceName());
        existingDevice.setDeviceType(updateDevice.getDeviceType());
        existingDevice.setRamCapacity(updateDevice.getRamCapacity());

        deviceDAO.update(existingDevice);
        return "Cập nhật thiết bị thành công!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        deviceDAO.delete(id);
        return "Xoá thiết bị thành công!";
    }
}

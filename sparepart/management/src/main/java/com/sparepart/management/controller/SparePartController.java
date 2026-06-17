package com.sparepart.management.controller;

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

import com.sparepart.management.dao.SparePartDAO;
import com.sparepart.management.entity.SparePart;

@RequestMapping("/api/spareparts")
@RestController
public class SparePartController {
    
    private SparePartDAO sparePartDAO;

    @Autowired
    public SparePartController(SparePartDAO sparePartDAO) {
        this.sparePartDAO = sparePartDAO;
    }

    @Value("${name.sparepart}")
    private String nameSparePart;

    @Value("${address.sparepart}")
    private String address;

    @GetMapping
    public List<SparePart> getAll() {
        return sparePartDAO.findAll();
    }

    @GetMapping("/info")
    public String getInfo() {
        return nameSparePart + " địa chỉ tại: " + address + ". Xin chào quý khách!!";
    }

    @GetMapping("/{id}")
    public SparePart getById(@PathVariable int id) {
        return sparePartDAO.findById(id);
    }

    @PostMapping("/add")
    public SparePart addPart(@RequestBody SparePart newPart) {
        newPart.setId(0);
        sparePartDAO.save(newPart);
        return newPart;
    }

    @PutMapping("/edit/{id}")
    public String updatedPart(@PathVariable int id, @RequestBody SparePart updateInfo) {
        SparePart existingPart = sparePartDAO.findById(id);
        if (existingPart == null) {
            return "Không tìm thấy phụ tùng nào có id: " + id;
        }

        existingPart.setPartName(updateInfo.getPartName());
        existingPart.setMotorType(updateInfo.getMotorType());
        existingPart.setStockQuantity(updateInfo.getStockQuantity());

        sparePartDAO.update(existingPart);
        return "Cập nhật thông tin phụ tùng " + id + " thành công!!!";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePart(@PathVariable int id) {
        SparePart temp = sparePartDAO.findById(id);
        if (temp == null) {
            return "Không tồn tại phụ tùng có id: " + id;
        }
        sparePartDAO.delete(id);
        return "Đã xoá phụ tùng " + id;
    }
}

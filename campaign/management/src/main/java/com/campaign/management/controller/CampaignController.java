package com.campaign.management.controller;

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

import com.campaign.management.dao.CampaignDAO;
import com.campaign.management.entity.Campaign;

@RequestMapping("/api/campaigns")
@RestController
public class CampaignController {
    
    private CampaignDAO campaignDAO;

    @Autowired
    public CampaignController(CampaignDAO campaignDAO) {
        this.campaignDAO = campaignDAO;
    }

    @GetMapping
    public List<Campaign> getAll() {
        return campaignDAO.findAll();
    }

    @GetMapping("/{id}")
    public Campaign getById(@PathVariable int id) {
        return campaignDAO.findById(id);
    }

    @PostMapping("/add")
    public String addCampaign(@RequestBody Campaign newCampaign) {
        newCampaign.setId(0);
        campaignDAO.save(newCampaign);
        return "Thêm chiến dịch mới thành công!!!";
    }

    @PutMapping("/edit/{id}")
    public String updateCampaign(@PathVariable int id, @RequestBody Campaign updateInfo) {
        Campaign existingCampaign = campaignDAO.findById(id);
        if (existingCampaign == null) {
            return "Không tìm thấy chiến dịch có ID: " + id;
        }

        existingCampaign.setCampaignName(updateInfo.getCampaignName());
        existingCampaign.setPlatform(updateInfo.getPlatform());
        existingCampaign.setBudget(updateInfo.getBudget());

        campaignDAO.update(existingCampaign);
        return "Đã cập nhật thông tin.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id) {
        Campaign temp = campaignDAO.findById(id);
        if (temp == null) {
            return "Không tìm thấy chiến dịch có ID: " + id;
        }
        campaignDAO.deleteById(id);
        return "Đã xoá chiến dịch có ID: " + id;
    }
}

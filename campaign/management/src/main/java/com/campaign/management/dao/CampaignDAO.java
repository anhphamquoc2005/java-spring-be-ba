package com.campaign.management.dao;

import java.util.List;

import com.campaign.management.entity.Campaign;

public interface CampaignDAO {

    void save(Campaign campaign);
    Campaign findById(int id);
    void deleteById(int id);
    void update(Campaign campaign);
    List<Campaign> findAll();
}
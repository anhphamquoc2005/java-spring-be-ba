package com.campaign.management.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.campaign.management.entity.Campaign;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CampaignDAOImpl implements CampaignDAO{
    
    private EntityManager entityManager;

    public CampaignDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Campaign theCampaign = entityManager.find(Campaign.class, id);
        if (theCampaign != null) {
            entityManager.remove(theCampaign);;
        }
    }

    @Override
    public List<Campaign> findAll() {
        TypedQuery<Campaign> query = entityManager.createQuery("FROM Campaign", Campaign.class);
        return query.getResultList();
    }

    @Override
    public Campaign findById(int id) {
        Campaign campaign = entityManager.find(Campaign.class, id);
        return campaign;
    }

    @Transactional
    @Override
    public void save(Campaign campaign) {
        entityManager.persist(campaign);
    }

    @Transactional
    @Override
    public void update(Campaign campaign) {
        entityManager.merge(campaign);
    }
}

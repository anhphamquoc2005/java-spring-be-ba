package com.itjob.management.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itjob.management.entity.ItJob;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ItJobDAOImpl implements ItJobDAO{
    private EntityManager entityManager;

    public ItJobDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void delete(int id) {
        ItJob job = entityManager.find(ItJob.class, id);
        if (job != null) {
            entityManager.remove(job);
        }
    }

    @Override
    public List<ItJob> findAll() {
        TypedQuery<ItJob> query = entityManager.createQuery("FROM ItJob", ItJob.class);
        return query.getResultList();
    }

    @Override
    public ItJob findById(int id) {
        return entityManager.find(ItJob.class, id);
    }

    @Transactional
    @Override
    public void save(ItJob itJob) {
        entityManager.persist(itJob);
    }

    @Transactional
    @Override
    public void update(ItJob itJob) {
        entityManager.merge(itJob);
    }
}

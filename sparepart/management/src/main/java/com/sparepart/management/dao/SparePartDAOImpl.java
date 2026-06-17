package com.sparepart.management.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sparepart.management.entity.SparePart;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class SparePartDAOImpl implements SparePartDAO{
    
    private EntityManager entityManager;

    public SparePartDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void delete(int id) {
        SparePart temp = entityManager.find(SparePart.class, id);
        if (temp != null) {
            entityManager.remove(temp);
        }
    }

    @Override
    public List<SparePart> findAll() {
        TypedQuery<SparePart> query = entityManager.createQuery("FROM SparePart", SparePart.class);
        return query.getResultList();
    }

    @Override
    public SparePart findById(int id) {
        return entityManager.find(SparePart.class, id);
    }

    @Transactional
    @Override
    public void save(SparePart sparePart) {
        entityManager.persist(sparePart);
    }

    @Transactional
    @Override
    public void update(SparePart sparePart) {
        entityManager.merge(sparePart);
    }
}

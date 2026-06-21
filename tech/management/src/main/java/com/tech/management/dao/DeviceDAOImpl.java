package com.tech.management.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tech.management.entity.Device;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class DeviceDAOImpl implements DeviceDAO{
    
    private EntityManager entityManager;

    public DeviceDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void delete(int id) {
        Device temp = entityManager.find(Device.class, id);
        if (temp != null) {
            entityManager.remove(temp);
        }
    }

    @Override
    public List<Device> findAll() {
        TypedQuery<Device> query = entityManager.createQuery("FROM Device", Device.class);
        return query.getResultList();
    }

    @Override
    public Device findById(int id) {
        Device theDevice = entityManager.find(Device.class, id);
        return theDevice;
    }

    @Transactional
    @Override
    public void save(Device device) {
        entityManager.persist(device);
    }

    @Transactional
    @Override
    public void update(Device device) {
        entityManager.merge(device);
    }
}

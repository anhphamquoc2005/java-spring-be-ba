package com.arsenal.management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.arsenal.management.entity.Player;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class PlayerDAOImpl implements PlayerDAO{

    private EntityManager entityManager;

    @Autowired
    public PlayerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void delete(int id) {
        Player player = entityManager.find(Player.class, id);
        if (player != null) {
            entityManager.remove(player);
        }
    }

    @Override
    public List<Player> findAll() {
        TypedQuery<Player> query = entityManager.createQuery("FROM Player", Player.class);
        return query.getResultList();
    }

    @Override
    public Player findById(int id) {
        return entityManager.find(Player.class, id);
    }

    @Transactional
    @Override
    public void save(Player player) {
        entityManager.persist(player);
    }

    @Transactional
    @Override
    public void update(Player player) {
        entityManager.merge(player);
    }
}

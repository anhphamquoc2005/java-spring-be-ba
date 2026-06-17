package com.football.management.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.football.management.entity.Player;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class PlayerDAOImpl implements PlayerDAO{
    private EntityManager entityManager;

    public PlayerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Player temp = entityManager.find(Player.class, id);
        if (temp != null) {
            entityManager.remove(temp);
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

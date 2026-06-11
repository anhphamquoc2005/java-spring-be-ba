package com.coffeeshop.menu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coffeeshop.menu.entity.Drink;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class DrinkDAOImpl implements DrinkDAO{

    private EntityManager entityManager;

    public DrinkDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void delete(int id) {
        Drink theDrink = entityManager.find(Drink.class, id);
        if (theDrink != null) {
            entityManager.remove(theDrink);
        }
    }

    @Override
    public List<Drink> findAll() {
        TypedQuery<Drink> query = entityManager.createQuery("FROM Drink", Drink.class);
        return query.getResultList();
    }

    @Override
    public Drink findById(int id) {
        return entityManager.find(Drink.class, id);
    }

    @Transactional
    @Override
    public void save(Drink drink) {
        entityManager.persist(drink);
    }

    @Transactional
    @Override
    public void update(Drink drink) {
        entityManager.merge(drink);
    }
}

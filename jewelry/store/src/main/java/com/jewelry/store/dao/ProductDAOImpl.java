package com.jewelry.store.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jewelry.store.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ProductDAOImpl implements ProductDAO{
    private EntityManager entityManager;

    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void delete(int id) {
        Product theProduct = entityManager.find(Product.class, id);
        if (theProduct != null) {
            entityManager.remove(theProduct);
        };
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }
}

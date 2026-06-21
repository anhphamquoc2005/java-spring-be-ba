package com.task.management.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.task.management.entity.Task;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class TaskDAOImpl implements TaskDAO{
    
    private EntityManager entityManager;

    public TaskDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void delete(int id) {
        Task temp = entityManager.find(Task.class, id);
        if (temp != null) {
            entityManager.remove(temp);
        }
    }

    @Override
    public List<Task> findAll() {
        TypedQuery<Task> query = entityManager.createQuery("FROM Task", Task.class);
        return query.getResultList();
    }

    @Override
    public Task findById(int id) {
        Task task = entityManager.find(Task.class, id);
        return task;
    }

    @Transactional
    @Override
    public void save(Task task) {
        entityManager.persist(task); 
    }

    @Transactional
    @Override
    public void update(Task task) {
        entityManager.merge(task);
    }
}

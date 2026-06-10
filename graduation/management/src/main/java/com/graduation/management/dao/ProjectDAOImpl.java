package com.graduation.management.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.graduation.management.entity.Project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class ProjectDAOImpl implements ProjectDAO{

    private EntityManager entityManager;

    public ProjectDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void delete(int id) {
        Project theProject = entityManager.find(Project.class, id);
        if (theProject != null) {
            entityManager.remove(theProject);
        }
    }

    @Override
    public List<Project> findAll() {
        TypedQuery<Project> query = entityManager.createQuery("FROM Project", Project.class);
        return query.getResultList();
    }

    @Override
    public Project findById(int id) {
        return entityManager.find(Project.class, id);
    }

    @Transactional
    @Override
    public void save(Project project) {
        entityManager.persist(project);
    }

    @Transactional
    @Override
    public void update(Project project) {
        entityManager.merge(project);
    }
    
}

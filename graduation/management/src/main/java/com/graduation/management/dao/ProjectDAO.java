package com.graduation.management.dao;

import java.util.List;

import com.graduation.management.entity.Project;

public interface ProjectDAO {

    void save(Project project);
    Project findById(int id);
    void delete(int id);
    void update(Project project);
    List<Project> findAll();
}
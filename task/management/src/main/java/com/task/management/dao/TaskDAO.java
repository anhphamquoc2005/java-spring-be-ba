package com.task.management.dao;

import java.util.List;

import com.task.management.entity.Task;

public interface TaskDAO {

    void save(Task task);
    Task findById(int id);
    void update(Task task);
    void delete(int id);
    List<Task> findAll();
}
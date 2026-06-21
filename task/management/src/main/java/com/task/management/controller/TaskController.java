package com.task.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.management.dao.TaskDAO;
import com.task.management.entity.Task;

@RequestMapping("/api/tasks")
@RestController
public class TaskController {
    
    private TaskDAO taskDAO;

    @Autowired
    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GetMapping
    public List<Task> getAll() {
        return taskDAO.findAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable int id) {
        return taskDAO.findById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody Task newTask) {
        newTask.setId(0);
        taskDAO.save(newTask);
        return "Thêm mới công việc thành công!";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody Task updateTask) {
        Task existingTask = taskDAO.findById(id);
        if (existingTask == null) {
            return "Không tìm thấy công việc có ID: " + id;
        }

        existingTask.setTaskName(updateTask.getTaskName());
        existingTask.setStatus(updateTask.getStatus());
        existingTask.setPriority(updateTask.getPriority());

        taskDAO.update(existingTask);
        return "Cập nhật công việc thành công!";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        taskDAO.delete(id);
        return "Xoá công việc thành công!";
    }
}

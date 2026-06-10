package com.graduation.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduation.management.dao.ProjectDAO;
import com.graduation.management.entity.Project;

@RestController
@RequestMapping("/api")
public class ProjectController {
    
    private ProjectDAO projectDAO;

    @Autowired
    public ProjectController(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectDAO.findAll();
    }

    @GetMapping("/project/{projectId}")
    public Project getProjectById(@PathVariable int projectId) {
        return projectDAO.findById(projectId);
    }
}

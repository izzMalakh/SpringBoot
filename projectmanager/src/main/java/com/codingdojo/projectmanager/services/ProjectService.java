package com.codingdojo.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.repositories.ProjectRepo;



@Service
public class ProjectService {
    private final ProjectRepo projectRepo;

    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public List<Project> allProjects(){
        return projectRepo.findAll();
    }

    public Project updateProject(Project project) {
        return projectRepo.save(project);
    }

    public List<Project> getAssignedUsers(User user){
    	System.out.print(projectRepo.findAllByUsers(user));
        return projectRepo.findAllByUsers(user);
    }

    public List<Project> getUnassignedUsers(User user){
        return projectRepo.findByUsersNotContains(user);
    }
    public List<Project> findAllassignedprojects(Long id){
        return projectRepo.findAllassignedprojects(id);
    }
    

    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    public void deleteProject(Project project) {
        projectRepo.delete(project);
    }

    public Project findById(Long id) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        }else {
            return null;
        }
    }

}

package com.codingdojo.projectmanager.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;

import java.util.List;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {
    List<Project> findAll();

    Project findByIdIs(Long id);

    List<Project> findAllByUsers(User user);

    List<Project> findByUsersNotContains(User user);
    
    @Query(value="SELECT * FROM projects WHERE user_id = ?1" ,nativeQuery=true)
    List<Project> findAllassignedprojects(Long id);

}

package com.codingdojo.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.projectmanager.models.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long>{
	List<Task> findAll();
    Task findByIdIs(Long id);
	List<Task> findByProjectIdIs(Long id);

}

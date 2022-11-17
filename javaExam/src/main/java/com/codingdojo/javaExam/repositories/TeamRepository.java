package com.codingdojo.javaExam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javaExam.models.Team;
import com.codingdojo.javaExam.models.User;



@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {
	List<Team> findAll();
	

	Optional<Team> findByname(String team);
	
}
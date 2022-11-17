package com.codingdojo.javaExam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javaExam.models.Team;
import com.codingdojo.javaExam.models.User;




@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	
	Optional<User> findByEmail(String email);
	List<User> findByJointeamsNotContains(Team team);
	List<User> findAllByJointeams(Team team);
	
}
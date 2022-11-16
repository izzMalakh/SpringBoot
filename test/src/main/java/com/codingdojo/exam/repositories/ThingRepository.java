package com.codingdojo.exam.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.exam.models.Thing;





@Repository
public interface ThingRepository extends CrudRepository<Thing,Long> {
	List<Thing> findAll();
	

	Optional<Thing> findByname(String thing);
}
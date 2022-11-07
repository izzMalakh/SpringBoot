package com.codingdojo.dojoandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.models.Ninja;
@Repository
public interface NinjaRepository  extends CrudRepository<Ninja ,Long> {
	List<Ninja> findAll();
}

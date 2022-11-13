package com.codingdojo.clubb.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.clubb.models.Borrow;


@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Long> {
	List<Borrow> findAll();
}
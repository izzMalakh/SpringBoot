package com.codingdojo.clubb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.clubb.models.Book;
import com.codingdojo.clubb.models.User;



@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	List<Book> findAllByUser(User user);
	List<Book> findByBorrowerIdIs(Long userId);
	List<Book> findByBorrowerIdIsOrUserIdIs(Long borrowerID, Long userId);
	
	
}

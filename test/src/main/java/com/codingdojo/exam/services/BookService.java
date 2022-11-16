package com.codingdojo.exam.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.exam.models.Book;
import com.codingdojo.exam.repositories.BookRepository;





@Service
public class BookService {
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	public Book bookExsist(Book book,BindingResult result) {
		if(bookRepo.findByname(book.getTitle()).isPresent()) {
			 result.rejectValue("name","Unique","This books taken!!");
		}
		
		if(result.hasErrors()) {			
			return null;
		}else {
			return bookRepo.save(book);
		}
	}
	
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	public Book singleBook(Long id) {
		Optional<Book> optBook = bookRepo.findById(id);
		if(optBook.isPresent()) {
			return optBook.get();
		}else {
			return null;
		}
	}

	public Book updateBook(Book book) {
		return bookRepo.save(book);
		
	}
}
package com.codingdojo.clubb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.clubb.models.Book;
import com.codingdojo.clubb.models.User;
import com.codingdojo.clubb.repositories.BookRepository;



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
	
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}




	public Book singleBook(Long id) {
		Optional<Book> optBook = bookRepo.findById(id);
		if(optBook.isPresent()) {
			return optBook.get();
		}else {
			return null;
		}
	}
	
//	public Book updateBook(Book book) {
//		Optional<Book> optBook = bookRepo.findById(book.getId());
//		if(optBook.isPresent()) {
//			Book thisBook = optBook.get();
//			thisBook.setTitle(book.getTitle());
//			thisBook.setAuthor(book.getAuthor());
//			thisBook.setThoughts(book.getThoughts());
//			thisBook.setId(book.getId());
//			return bookRepo.save(thisBook);
//		}else {
//			return null;
//		}
//	}
	 public void deleteBook(Long id) {
		 bookRepo.deleteById(id);
	    }
	 public List<Book> unborrowedBooks(User user){
			return bookRepo.findByBorrowerIdIsOrUserIdIs(null, user.getId());
		}
		
		public List<Book> borrowedBooks(User user){
			return bookRepo.findByBorrowerIdIs(user.getId());
		}
		public void removeBorrower(Book book) {
			book.setBorrower(null);
			bookRepo.save(book);
		}
		
		public void addBorrower(Book book, User user) {
			book.setBorrower(user);
			bookRepo.save(book);
		}
}
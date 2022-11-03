package com.codingdojo.mvc.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookContoller {
	private final BookService bookService;

	public BookContoller(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("/api/bookss")
	public String index(Model model) {
        List<Book> books = bookService.allBooks();

		model.addAttribute("books", books);
		return "index.jsp";
	}
	@RequestMapping("/books/{id}")
	public String indexx(Model model, @PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);

		
		return "showbook.jsp";
	}
	
}

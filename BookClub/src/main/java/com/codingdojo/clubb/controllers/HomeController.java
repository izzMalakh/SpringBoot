package com.codingdojo.clubb.controllers;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.clubb.models.Book;
import com.codingdojo.clubb.models.LoginUser;
import com.codingdojo.clubb.models.User;
import com.codingdojo.clubb.services.BookService;
import com.codingdojo.clubb.services.UserService;

@Controller
public class HomeController {
	private final BookService bookSer;
	private final UserService userSer;
	
	public HomeController(BookService bookSer, UserService userSer) {
		this.bookSer = bookSer;
		this.userSer = userSer;
	}
	
	// ================================ GENERAL ================================ 
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		if(session.getAttribute("user_id") != null ) {
			return "redirect:/dashboard";
		}else {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}	
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("user_id") != null ) {
			Long loggedID = (Long) session.getAttribute("user_id");
			User userName = userSer.oneUser(loggedID);
			List<Book> allBooks = bookSer.allBooks();
			Collections.reverse(allBooks);
			model.addAttribute("logged",userName);
			model.addAttribute("loggedID",loggedID);
			model.addAttribute("allBooks",allBooks);
			return "dashboard.jsp";
		}else {
			return "redirect:/";
		}
	}
	
	// ================================ LOGIN / REGISTRATION ================================
		@PostMapping("/api/register")
		public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
			
			userSer.register(newUser, result);
			
			if(result.hasErrors()) {
				model.addAttribute("newLogin", new LoginUser());
				return "index.jsp";
			}
			
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/dashboard";
		}
		
		@PostMapping("/api/login")
		public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
			User user = userSer.login(newLogin, result);
			if(result.hasErrors()) {
				model.addAttribute("newUser", new User());
				return "index.jsp";
			}
			
			session.setAttribute("user_id", user.getId());
			return "redirect:/dashboard";
		}
		
		@GetMapping("/logout")
		public String dashboard(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		@GetMapping("/add/book")
		public String addingbook(@ModelAttribute("book") Book book,Model model, HttpSession session) {
			if(session.getAttribute("user_id") != null ) {
				Long loggedID = (Long) session.getAttribute("user_id");
				model.addAttribute("logged",loggedID);
				return "addingbook.jsp";
			}else {
				return "redirect:/";
			}
		}
		@PostMapping("/api/add/book")
		public String handleaddingform(@Valid @ModelAttribute("book") Book book, BindingResult result) {
			if(result.hasErrors()) {
				return "addingbook.jsp";
			}else {
				bookSer.createBook(book);
				return "redirect:/dashboard";
			}
		}
		@GetMapping("/book/{id}")
		public String showdatails(Model model,@PathVariable("id")Long id) {
			Book thisBook = bookSer.singleBook(id);
			model.addAttribute("book",thisBook);
			return "bookDetails.jsp";
		}
		@DeleteMapping("/book/delete/{id}")
		 public String destroy(@PathVariable("id") Long id) {
			bookSer.deleteBook(id);
	        return "redirect:/";
		}
		@GetMapping("/edit/book/{id}")
		public String editBook(Model model,HttpSession session, @PathVariable("id")Long id) {
			if(session.getAttribute("user_id") != null ) {
				Book book = bookSer.singleBook(id);
				model.addAttribute("book",book);
				return "editBook.jsp";
			}else {
				return "redirect:/";
			}
		}
		@PutMapping("/api/edit/book/{id}")
		public String handleedit(@Valid @ModelAttribute("book") Book book, BindingResult result,HttpSession session) {
			if(result.hasErrors()) {
				return "editBook.jsp";
			}else {
				Long userId =(Long) session.getAttribute("user_id");
				User currentuser = userSer.oneUser(userId);
				book.setUser(currentuser);
				
				bookSer.updateBook(book);
				return "redirect:/dashboard";
			}
		}
}
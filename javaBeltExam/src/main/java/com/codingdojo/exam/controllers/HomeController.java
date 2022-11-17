package com.codingdojo.exam.controllers;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.exam.models.LoginUser;
import com.codingdojo.exam.models.Book;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.services.BookService;
import com.codingdojo.exam.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private final UserService userSer;
	private final BookService bookSer;

	
	public HomeController(UserService userSer,BookService bookSer){
		super();
		this.userSer = userSer;
		this.bookSer = bookSer;
		
	}
	// ================================ GENERAL ================================
		@GetMapping("/")
		public String index(Model model, HttpSession session) {
			if(session.getAttribute("user_id") != null ) {
				return "dashboard.jsp";
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
				User userr = userSer.oneUser(loggedID);
				List<Book> books = bookSer.allBooks();
				model.addAttribute("books",books);
				model.addAttribute("logged",userr);
				return "dashboard.jsp";
			}else {
				return "redirect:/";
			}
		}

		// ================================ LOGIN / REGISTRATION ================================
		@PostMapping("/api/register")
		public String register(@Valid @ModelAttribute("newUser") User newUser,BindingResult result, Model model, HttpSession session) {
						
				userSer.register(newUser, result);
				
			if(result.hasErrors()) {
				model.addAttribute("newLogin", new LoginUser());
				return "index.jsp";
			}
						
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/dashboard";
		}
					
		@PostMapping("/api/login")
		public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
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
		
		// ======================================== add route =============================================
		@GetMapping("/add/book")
		public String addBook(Model model,@ModelAttribute("book") Book book,HttpSession session,RedirectAttributes redirectAttributes) {
			Long loggedID = (Long) session.getAttribute("user_id");
			User userName = userSer.oneUser(loggedID);
			model.addAttribute("userName",userName);
			return "addBook.jsp";
		}
		
		@PostMapping("/api/add/book")
		public String addNameForm(Model model,@Valid @ModelAttribute("book") Book name,BindingResult result,HttpSession session,RedirectAttributes redirectAttributes) {
			
			bookSer.bookExsist(name,result);
			if(result.hasErrors()) {	
				return "addBook.jsp";
			}else {
				return "redirect:/dashboard";
				
			}
		}
		
		//============================================See Detail page==========================================================
		@GetMapping("/book/{id}")
		public String name(Model model,@PathVariable("id") Long id,HttpSession session) {
			Book book = bookSer.singleBook(id);
			Long loggedID = (Long) session.getAttribute("user_id");
			User userName = userSer.oneUser(loggedID);
			model.addAttribute("userName",userName);
			model.addAttribute("name",book);
			return "bookDetails.jsp";
		}
		
		//==============================================delete and edit methods=========================================================================
		@GetMapping("/edit/book/{id}")
		public String editName(Model model,HttpSession session,@PathVariable("id") Long id,@ModelAttribute("book") Book book) {
			Long loggedID = (Long) session.getAttribute("user_id");
			User userName = userSer.oneUser(loggedID);
			Book currentBook = bookSer.singleBook(id);
			model.addAttribute("userName",userName);
			model.addAttribute("currentBook",currentBook);
			return "editBook.jsp";
		}
		
		@PostMapping("/api/edit/book/{id}")
		public String updateNameForm(Model model,@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book,BindingResult result,HttpSession session) {
			if(result.hasErrors()) {
				Long loggedID = (Long) session.getAttribute("user_id");
				User userName = userSer.oneUser(loggedID);
				Book currentBook = bookSer.singleBook(id);
				model.addAttribute("userName",userName);
				model.addAttribute("currentBook",currentBook);
				return "editBook.jsp";
			}else {
				bookSer.updateBook(book);
				return "redirect:/dashboard";
			}
		}
		
		@RequestMapping("/delete/book/{id}")
	    public String destroy(@PathVariable("id") Long id) {
			bookSer.deleteBook(id);
	        return "redirect:/dashboard";
	    }
}
	

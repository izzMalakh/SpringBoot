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
import com.codingdojo.exam.models.Thing;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.services.ThingService;
import com.codingdojo.exam.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private final UserService userSer;
	private final ThingService thingSer;

	
	public HomeController(UserService userSer,ThingService thingSer){
		super();
		this.userSer = userSer;
		this.thingSer = thingSer;
		
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
				List<Thing> things = thingSer.allThings();
				model.addAttribute("things",things);
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
		@GetMapping("/add/thing")
		public String addThing(Model model,@ModelAttribute("thing") Thing thing,HttpSession session,RedirectAttributes redirectAttributes) {
			Long loggedID = (Long) session.getAttribute("user_id");
			User userName = userSer.oneUser(loggedID);
			model.addAttribute("userName",userName);
			return "addThing.jsp";
		}
		
		@PostMapping("/api/add/thing")
		public String addNameForm(Model model,@Valid @ModelAttribute("thing") Thing name,BindingResult result,HttpSession session,RedirectAttributes redirectAttributes) {
			
			thingSer.thingExsist(name,result);
			if(result.hasErrors()) {	
				return "addThing.jsp";
			}else {
				return "redirect:/dashboard";
				
			}
		}
		
		//============================================See Detail page==========================================================
		@GetMapping("/thing/{id}")
		public String name(Model model,@PathVariable("id") Long id,HttpSession session) {
			Thing thing = thingSer.singleThing(id);
			Long loggedID = (Long) session.getAttribute("user_id");
			User userName = userSer.oneUser(loggedID);
			model.addAttribute("userName",userName);
			model.addAttribute("name",thing);
			return "thingDetails.jsp";
		}
		
		//==============================================delete and edit methods=========================================================================
		@GetMapping("/edit/thing/{id}")
		public String editName(Model model,HttpSession session,@PathVariable("id") Long id,@ModelAttribute("thing") Thing thing) {
			Long loggedID = (Long) session.getAttribute("user_id");
			User userName = userSer.oneUser(loggedID);
			Thing currentThing = thingSer.singleThing(id);
			model.addAttribute("userName",userName);
			model.addAttribute("currentThing",currentThing);
			return "editThing.jsp";
		}
		
		@PostMapping("/api/edit/thing/{id}")
		public String updateNameForm(Model model,@PathVariable("id") Long id, @Valid @ModelAttribute("thing") Thing thing,BindingResult result,HttpSession session) {
			if(result.hasErrors()) {
				Long loggedID = (Long) session.getAttribute("user_id");
				User userName = userSer.oneUser(loggedID);
				Thing currentThing = thingSer.singleThing(id);
				model.addAttribute("userName",userName);
				model.addAttribute("currentThing",currentThing);
				return "editThing.jsp";
			}else {
				thingSer.updateThing(thing);
				return "redirect:/dashboard";
			}
		}
		
		@RequestMapping("/delete/thing/{id}")
	    public String destroy(@PathVariable("id") Long id) {
			thingSer.deleteThing(id);
	        return "redirect:/dashboard";
	    }
}
	

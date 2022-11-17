package com.codingdojo.javaExam.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.codingdojo.javaExam.models.LoginUser;
import com.codingdojo.javaExam.models.Team;
import com.codingdojo.javaExam.models.User;
import com.codingdojo.javaExam.services.TeamService;
import com.codingdojo.javaExam.services.UserService;



@Controller
public class HomeController {
	@Autowired
	private final UserService userSer;
	private final TeamService teamSer;

	
	public HomeController(UserService userSer,TeamService teamSer){
		super();
		this.userSer = userSer;
		this.teamSer = teamSer;
		
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
				List<Team> teams = teamSer.allTeams();
				model.addAttribute("teams",teams);
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
				@GetMapping("/add/team")
				public String addTeam(Model model,@ModelAttribute("team") Team team,HttpSession session,RedirectAttributes redirectAttributes) {
					
					Long loggedID = (Long) session.getAttribute("user_id");
					User userName = userSer.oneUser(loggedID);
					model.addAttribute("userName",userName);
					return "addTeam.jsp";
				}
				
				@PostMapping("/api/add/team")
				public String addNameForm(Model model,@Valid @ModelAttribute("team") Team team,BindingResult result,HttpSession session,RedirectAttributes redirectAttributes) {
					
					teamSer.teamExsist(team,result);
					if(result.hasErrors()) {	
						return "addTeam.jsp";
					}else {
						return "redirect:/dashboard";
						
					}
				}
				
				//============================================See Detail page==========================================================
				@GetMapping("/team/{id}")
				public String name(Model model,@PathVariable("id") Long id,HttpSession session) {
					
					Long loggedID = (Long) session.getAttribute("user_id");
					User user = userSer.oneUser(loggedID);
					Team team = teamSer.singleTeam(id);
					model.addAttribute("assignedUsers", userSer.getAssignedteams(team));
					model.addAttribute("unassignedUsers", userSer.getUnassignedteams(team));
					model.addAttribute("userName",user);
					model.addAttribute("name",team);
					return "teamDetails.jsp";
				}
				
				
				@PostMapping("/team/{id}")
				public String editCategory(@PathVariable("id") Long id, @RequestParam(value="userId") Long userId,  Model model) {
					
				
					User player = userSer.oneUser(userId);
					Team team = teamSer.singleTeam(id);
					
					team.getPlayers().add(player);
					teamSer.createTeam(team);
					model.addAttribute("assignedUsers", userSer.getAssignedteams(team));
					model.addAttribute("unassignedCategories", userSer.getUnassignedteams(team));
					
					return "redirect:/team/" + id;
				}
				
				//==============================================delete and edit methods=========================================================================
				@GetMapping("/edit/team/{id}")
				public String editName(Model model,HttpSession session,@PathVariable("id") Long id,@ModelAttribute("team") Team team) {
					Long loggedID = (Long) session.getAttribute("user_id");
					User userName = userSer.oneUser(loggedID);
					Team currentTeam = teamSer.singleTeam(id);
					model.addAttribute("userName",userName);
					model.addAttribute("currentTeam",currentTeam);
					return "editTeam.jsp";
				}
				
				@PostMapping("/api/edit/team/{id}")
				public String updateNameForm(Model model,@PathVariable("id") Long id, @Valid @ModelAttribute("team") Team team,BindingResult result,HttpSession session) {
					teamSer.teamExsist(team,result);
					Long loggedID = (Long) session.getAttribute("user_id");
					User userName = userSer.oneUser(loggedID);
					Team currentTeam = teamSer.singleTeam(id);
					
					if(result.hasErrors()) {
						model.addAttribute("userName",userName);
						model.addAttribute("currentTeam",currentTeam);
				
						return "editTeam.jsp";
					}else {
						
						return "redirect:/dashboard";
					}
				}
				
				@RequestMapping("/delete/team/{id}")
			    public String destroy(@PathVariable("id") Long id) {
					teamSer.deleteTeam(id);
			        return "redirect:/dashboard";
			    }
				//=================================================
			
				
}
		
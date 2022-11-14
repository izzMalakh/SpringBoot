package com.codingdojo.projectmanager.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.projectmanager.models.LoginUser;
import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.Task;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.services.ProjectService;
import com.codingdojo.projectmanager.services.TaskService;
import com.codingdojo.projectmanager.services.UserService;

@Controller

public class HomeController {
	private final UserService userSer;
	private final ProjectService proSer;
	private final TaskService taskSer;
	public HomeController(UserService userSer, ProjectService proSer,TaskService taskSer) {
		
		this.userSer = userSer;
		this.proSer = proSer;
		this.taskSer = taskSer;
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
			User thisuser = userSer.findById(loggedID);
			List<Project> allunprojects = proSer.getUnassignedUsers(thisuser);
			List<Project> allass1projects = proSer.getAssignedUsers(thisuser);
			List<Project> allassprojects = proSer.findAllassignedprojects(loggedID);
			model.addAttribute("thisuser",thisuser);
			model.addAttribute("loggedID",loggedID);
			model.addAttribute("allunassprojects",allunprojects);
			model.addAttribute("allassprojects",allass1projects);
			model.addAttribute("myprojects",allassprojects);
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
		@GetMapping("/add/project")
		public String addp(@ModelAttribute("project")Project project,HttpSession session, Model model) {
			Long loggedID = (Long) session.getAttribute("user_id");
			   model.addAttribute("thisuser", userSer.findById(loggedID));
			   return "newproject.jsp";

		}
		@PostMapping("/projects/create")
		   public String createbook(@Valid @ModelAttribute("project")Project project, BindingResult result,HttpSession session) {
			   if (result.hasErrors()) {
				   
				   return "newproject.jsp";
			   }
			   else {
				   
			       proSer.addProject(project);
				   return "redirect:/dashboard";
				   
			   }
		   }
		@GetMapping("/jointeam/{id}")
		public String jointeam(HttpSession session, Model model,@PathVariable("id") Long projID) {
			Long loggedID = (Long) session.getAttribute("user_id");
			User thisuser = userSer.findById(loggedID);
			Project thisproject = proSer.findById(projID);
			thisproject.getUsers().add(thisuser);
			proSer.updateProject(thisproject);
			System.out.println(thisproject);
			System.out.println("izz");
			return "redirect:/dashboard";

		}
		@GetMapping("/leaveteam/{id}")
		public String lavaeteam(HttpSession session, Model model,@PathVariable("id") Long projID) {
			Long loggedID = (Long) session.getAttribute("user_id");
			User thisuser = userSer.findById(loggedID);
			Project thisproject = proSer.findById(projID);
			thisproject.getUsers().remove(thisuser);
			proSer.updateProject(thisproject);
			
			return "redirect:/dashboard";

		}
		@GetMapping("/editproject/{id}")
		public String editBook(Model model,HttpSession session, @PathVariable("id")Long id) {
			if(session.getAttribute("user_id") != null ) {
				Project pro = proSer.findById(id);
				model.addAttribute("project",pro);
				return "editBook.jsp";
			}else {
				return "redirect:/";
			}
		}
		@PostMapping("/projects/edit/{id}")
		public String handleedit(@Valid @ModelAttribute("project") Project project, BindingResult result,HttpSession session) {
			if(result.hasErrors()) {
				return "editBook.jsp";
			}else {
				Long userId =(Long) session.getAttribute("user_id");
				User currentuser = userSer.findById(userId);
				project.setLead(currentuser);
				
				proSer.updateProject(project);
				return "redirect:/dashboard";
			}
		}
		
		@GetMapping("/projects/{id}")
		public String showdatails(Model model,@PathVariable("id")Long id) {
			Project thisproject = proSer.findById(id);
			model.addAttribute("project",thisproject);
			return "projectDetails.jsp";
		}
		
		@RequestMapping("/project/delete/{id}")
		 public String destroy(@PathVariable("id") Long id) {
			Project thisproject = proSer.findById(id);
			proSer.deleteProject(thisproject);
	        return "redirect:/";
		}
		
		@GetMapping("/project/{id}/tasks")
		public String showtasks(Model model,@PathVariable("id")Long id,HttpSession session,@ModelAttribute("task") Task task) {
			Project thisproject = proSer.findById(id);
			model.addAttribute("project",thisproject);

			Long loggedID = (Long) session.getAttribute("user_id");
			model.addAttribute("thisuser", userSer.findById(loggedID));
			model.addAttribute("tasks", taskSer.projectTasks(id));
			return "addtask.jsp";
		}
		@PostMapping("/projects/{id}/tasks")
		public String newProjectTask(
				@PathVariable("id") Long id, 
				HttpSession session, 
				Model model, 
				@Valid @ModelAttribute("task") Task task, 
				BindingResult result) {
			
			if(session.getAttribute("user_id") == null) {
				return "redirect:/logout";
			}
			Long userId = (Long) session.getAttribute("userId");
			Project project = proSer.findById(id);
			if(result.hasErrors()) {
				model.addAttribute("project", project);
				model.addAttribute("tasks", taskSer.projectTasks(id));
				return "addtask.jsp";
			}else {
				Task newTask = new Task(task.getName());
				newTask.setProject(project);
				newTask.setCreator(userSer.findById(userId));
				taskSer.addTask(newTask);
				return "redirect:/project/" + id + "/tasks";
			}
		}
	
		
	
}

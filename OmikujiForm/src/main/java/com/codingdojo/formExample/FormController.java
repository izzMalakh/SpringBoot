package com.codingdojo.formExample;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
	@RequestMapping("/omikuji")
	public String home() {
		return "form.jsp";
	}
	
@PostMapping("/handleform") 
public String submit(
		HttpSession session,
		@RequestParam(value="number") String number,
		@RequestParam(value="city") String city,
		@RequestParam(value="person") String person,
		@RequestParam(value="hobby") String hobby,
		@RequestParam(value="thing") String thing,
		@RequestParam(value="message") String message) {
			session.setAttribute("number", number);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("hobby", hobby);
			session.setAttribute("thing", thing);
			session.setAttribute("message", message);
			return "redirect:/omikuji/show";
}
@GetMapping("/omikuji/show") // to avoid resubmission warrning! but i will lose the data we will use session too
public String show() {
	return "result.jsp";
}


}

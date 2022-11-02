package com.codingdojo.NinjaGold;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaController {
	@GetMapping("/")
	public String index() {		
		return "redirect:/Gold";
	}
	
	@GetMapping("/Gold")
	public String home(HttpSession session) {
		if(session.getAttribute("messages") == null) {
			session.setAttribute("messages", new ArrayList<String>());
		}
		
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		
		Integer allGold = (Integer) session.getAttribute("gold");
		session.setAttribute("gold", allGold);
		
		return "index.jsp";
	}
	
	@RequestMapping(path="process_money/{id}", method=RequestMethod.POST)
	public String process(HttpSession session, @PathVariable int id,Model model) {
		Random rand = new Random();
		Date now = new Date();
		if(id == 1) {
			//randomGenerator.nextInt((maximum – minimum) + 1) + minimum
			Integer newgold = rand.nextInt(11)+10;
			Integer currentgold = (Integer) session.getAttribute("gold");
			String status = "You entered a farm and earn"+" "+ newgold +"." + "(" + now +")";
			((ArrayList<String>) session.getAttribute("messages")).add(status);
			session.setAttribute("gold", currentgold+newgold);
		}
		if(id == 2) {
			//randomGenerator.nextInt((maximum – minimum) + 1) + minimum
			Integer newgold = rand.nextInt(11)+10;
			Integer currentgold = (Integer) session.getAttribute("gold");
			
			String status = "You entered a farm and earn"+" "+ newgold +"." + "(" + now +")";
			
			((ArrayList<String>) session.getAttribute("messages")).add(status);
			session.setAttribute("gold", currentgold+newgold);
		}
		if(id == 3) {
			//randomGenerator.nextInt((maximum – minimum) + 1) + minimum
			Integer newgold = rand.nextInt(11)+10;
			Integer currentgold = (Integer) session.getAttribute("gold");
			
			String status = "You entered a farm and earn"+" "+ newgold +"." + "(" + now +")";
			
			((ArrayList<String>) session.getAttribute("messages")).add(status);
			
			session.setAttribute("gold", currentgold+newgold);
		}
		if(id == 4) {
			//randomGenerator.nextInt((50 – -50) + 1) + -50 = 
			Integer newgold = rand.nextInt(101)-50;
			Integer currentgold = (Integer) session.getAttribute("gold");
			if(newgold <=0) {
				String status = "You faild a quest and lost"+" "+ -1*newgold +"." +"Ouch! "+ "(" + now +")";
				((ArrayList<String>) session.getAttribute("messages")).add(status);
				session.setAttribute("gold", currentgold+newgold);
			}
			else if(newgold >=0) {
				
				String status = "You Completed a quest and earned"+" "+ newgold +"." + "(" + now +")";
				((ArrayList<String>) session.getAttribute("messages")).add(status);
				session.setAttribute("gold", currentgold+newgold);
			}
			
			
		}
		return "redirect:/Gold";
	}
	@RequestMapping("/reset")
	public String destroy(HttpSession session) {
		if(session.getAttribute("gold") != null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("messages") != null) {
			session.setAttribute("messages", null);
		}
		return "redirect:/Gold";
	}
	@RequestMapping("/clearDate")
	public String clear(HttpSession session) {
		
		if(session.getAttribute("messages") != null) {
			session.setAttribute("messages", null);
		}
		return "redirect:/Gold";
	}
	
}

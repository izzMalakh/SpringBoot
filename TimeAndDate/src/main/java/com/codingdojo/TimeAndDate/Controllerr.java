package com.codingdojo.TimeAndDate;



import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllerr {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		 LocalDate myObj = LocalDate.now();
		 
		model.addAttribute("date", myObj);
		return "showdate.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		LocalTime specificSecondTime = LocalTime.now();
		
		
		model.addAttribute("date", specificSecondTime);
		return "showtime.jsp";
	}
}

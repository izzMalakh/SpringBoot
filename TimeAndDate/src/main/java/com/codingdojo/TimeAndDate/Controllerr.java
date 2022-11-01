package com.codingdojo.TimeAndDate;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

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
		//returns a Calendar object whose calendar fields have been initialized with the current date and time  
		Calendar cal = Calendar.getInstance();  
		//creating a constructor of the SimpleDateFormat class  
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");  
		//getting current date  
		System.out.println("Today's date: "+sdf.format(cal.getTime()));  
		//creating a constructor of the Format class  
		//displaying full-day name  
		Format f = new SimpleDateFormat("EEEE");  
		Format y = new SimpleDateFormat("YYYY");  
		Format m = new SimpleDateFormat("MMMM"); 
		Format d = new SimpleDateFormat("dd");
		String dayName = f.format(new Date());  
		String yearName = y.format(new Date()); 
		String monthName = m.format(new Date()); 
		String numberDay = d.format(new Date()); 
		//prints day name  
		 
//		String pattern = "EEEEE dd MMMMM yyyy HH:mm:ss.SSSZ";
//		SimpleDateFormat simpleDateFormat =
//		        new SimpleDateFormat(pattern, new Locale("da", "DK"));
//
//		String date = simpleDateFormat.format(new Date());
		
		
		model.addAttribute("date", myObj);
		model.addAttribute("dayName", dayName);
		model.addAttribute("yearName", yearName);
		model.addAttribute("monthName", monthName);
		model.addAttribute("numberDay", numberDay);
		return "showdate.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
//		LocalTime specificSecondTime = LocalTime.now();
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String timeString = dateFormat.format(new Date()).toString();
    	model.addAttribute("date", timeString);
		return "showtime.jsp";
	}
}

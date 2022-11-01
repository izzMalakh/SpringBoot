package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterContoller {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			Integer Count = (Integer) session.getAttribute("count");
			Count++;
			session.setAttribute("count", Count);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/reset")
	public String resetCount(HttpSession session) {
		session.setAttribute("count", 0);
		return "index.jsp";
	}
	
	@RequestMapping("/double")
	public String doubleCount(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 2);
		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount += 2;
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
}

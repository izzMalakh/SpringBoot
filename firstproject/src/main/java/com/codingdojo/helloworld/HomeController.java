package com.codingdojo.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//...
@RestController

@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
    public String index(@RequestParam(value="firstname", required=false)String searchQuery, @RequestParam(value="lastname", required=false)String searchQuery1,@RequestParam(value="times", required=false)int var){
//		if (searchQuery!= null) {
		String yo="";
		for(int i=0;i<var;i++) {
			yo+="welcome " +searchQuery + " " + searchQuery1 +" ";
		}
		      return yo;
		
	}

//		else {
//			return "Welcome ";
//		
	    
    @RequestMapping("/today")
    
    public String hello(){
      return "Today you will find luck!";
    }
    @RequestMapping("/tomorrow")
    public String world(){
      return "tomorrow,an oppotinty will arise!";
    }
}


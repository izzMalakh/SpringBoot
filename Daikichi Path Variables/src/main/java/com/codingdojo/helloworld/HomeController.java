package com.codingdojo.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//...
@RestController

@RequestMapping("/dickishi")
public class HomeController {

	    
    @RequestMapping("/travel/{city}")
    
    public String hello(@PathVariable ("city") String city){
      return "Congrats you will travel to :"+ city;
    }
    
//        @RequestMapping("/m/{track}/{module}/{lesson}")
//        public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
//        	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
//        
//    }
    
    @RequestMapping("/lotto/{integer}")
    public String hello2(@PathVariable ("integer") int integger){
      if(integger%2==0) {
    	  return "You will take a grand journey in the near future, but be weary of tempting offers";
      }
      else {
    	  return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
      }
    }
}


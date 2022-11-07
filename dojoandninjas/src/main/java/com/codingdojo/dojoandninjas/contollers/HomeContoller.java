package com.codingdojo.dojoandninjas.contollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.models.Ninja;
import com.codingdojo.dojoandninjas.services.AppService;

@Controller
public class HomeContoller {
public final AppService appService;
public HomeContoller(AppService appService) {
	this.appService=appService;
}


@GetMapping("")
public String dojo(@ModelAttribute("dojo") Dojo dojo) {
	return "dojo.jsp";
}
@PostMapping("/dojos")
public String dojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) { //nfs ele td al jsp / type / object variable 
	if(result.hasErrors()) {
		return "dojo.jsp";
	}
	else {
		appService.createDojo(dojo);
		return "redirect:/";
	}
}
@GetMapping("/add/ninja")
public String addNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
	List<Dojo> dojos = appService.allDojos();
	model.addAttribute("dojos", dojos);
	return "addNinja.jsp";
}
@PostMapping("/api/add/ninja")
public String addFormNinja(Model model, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
	if(result.hasErrors()) {
		List<Dojo> dojos = appService.allDojos();
		model.addAttribute("dojos", dojos);
		return "addNinja.jsp";
	}else {
		appService.createNinja(ninja);
		return "redirect:/ninjas";
	}
}
@GetMapping("/ninjas")
public String allNinjas(Model model) {
	List<Ninja> ninjas = appService.allNinjas();
	model.addAttribute("ninjas", ninjas);
	return "ninjas.jsp";
}
@DeleteMapping("/delete/ninja/{id}")
public String destroyNinja( @PathVariable("id") Long id) {
	appService.deleteNinja(id);
	return "redirect:/ninjas";
}

}


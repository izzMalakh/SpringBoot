package com.codingdojo.FruityLoops;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.FruityLoops.model.Fruit;

@Controller
public class Control {
	@RequestMapping("/")
public String index(Model model) {
		ArrayList<Fruit> fruits = new ArrayList<Fruit>();
		Fruit kiwi = new Fruit("Kiwi", 1.5);
		Fruit Mango = new Fruit("Mango", 2.0);
		Fruit Goji = new Fruit("Goji Berries", 4.0);
		Fruit Guava = new Fruit("Guava", 0.75);
		fruits.add(kiwi);
		fruits.add(Mango);
		fruits.add(Goji);
		fruits.add(Guava);
		model.addAttribute("fruits", fruits);
		return "index.jsp";

	}
}

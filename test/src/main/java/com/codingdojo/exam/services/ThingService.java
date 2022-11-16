package com.codingdojo.exam.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.exam.models.Thing;
import com.codingdojo.exam.repositories.ThingRepository;





@Service
public class ThingService {
	private final ThingRepository thingRepo;
	
	public ThingService(ThingRepository itemRepo) {
		this.thingRepo = itemRepo;
	}
	
	public List<Thing> allThings(){
		return thingRepo.findAll();
	}
	
	public Thing createThing(Thing thing) {
		return thingRepo.save(thing);
	}
	
	public Thing thingExsist(Thing thing,BindingResult result) {
		if(thingRepo.findByname(thing.getName()).isPresent()) {
			 result.rejectValue("giventhing","Unique","This things taken!!");
		}
		
		if(result.hasErrors()) {			
			return null;
		}else {
			return thingRepo.save(thing);
		}
	}
	
	public void deleteThing(Long id) {
		thingRepo.deleteById(id);
	}
	
	public Thing singleThing(Long id) {
		Optional<Thing> optThing = thingRepo.findById(id);
		if(optThing.isPresent()) {
			return optThing.get();
		}else {
			return null;
		}
	}

	public Thing updateThing(Thing thing) {
		return thingRepo.save(thing);
		
	}
}
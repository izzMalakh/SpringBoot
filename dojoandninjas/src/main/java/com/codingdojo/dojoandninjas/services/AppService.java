package com.codingdojo.dojoandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.models.Ninja;
import com.codingdojo.dojoandninjas.repositories.DojoRepository;
import com.codingdojo.dojoandninjas.repositories.NinjaRepository;


@Service
public class AppService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository; // di for two repositories 
	public AppService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository=dojoRepository;
		this.ninjaRepository=ninjaRepository;
		
		
	}
	 // creates a ninja
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
 // creates a dojo
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
    
    // retrieves a dojo
    public Dojo findDojo(Long id) {
    	return this.dojoRepository.findById(id).orElse(null);
    }
 // retrieves a ninja
    public Ninja findNinja(Long id) {
    	return this.ninjaRepository.findById(id).orElse(null);
    }
 // retrieves all dojos
    public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
 // retrieves all ninjas
    public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
    //delete ninja
    public void deleteNinja(Long id) {
    	ninjaRepository.deleteById(id);
	}
	
}

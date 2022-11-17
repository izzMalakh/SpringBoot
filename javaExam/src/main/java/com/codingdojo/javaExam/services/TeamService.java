package com.codingdojo.javaExam.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.javaExam.models.Team;
import com.codingdojo.javaExam.models.User;
import com.codingdojo.javaExam.repositories.TeamRepository;


@Service
public class TeamService {
	private final TeamRepository teamRepo;
	
	public TeamService(TeamRepository teamRepo) {
		this.teamRepo = teamRepo;
	}
	
	public List<Team> allTeams(){
		return teamRepo.findAll();
	}
	
	public Team createTeam(Team team) {
		return teamRepo.save(team);
	}
	
//	public Team teamExsist(Team team,BindingResult result) {
//		if(teamRepo.findByname(team.getName()).isPresent()) {
//			 result.rejectValue("name","Unique","This teams taken!!");
//		}
//		
//		if(result.hasErrors()) {			
//			return null;
//		}else {
//			return teamRepo.save(team);
//		}
//	}
	public Team teamExsist(Team team,BindingResult result) {
		System.out.println(team.getDay().equals("Monday"));
		if(team.getDay().equals("Monday") || 
				team.getDay().equals("Tuesday") ||team.getDay().equals("Wednesday") ||team.getDay().equals("Thursday") ||team.getDay().equals("Friday") ||team.getDay().equals("Saturday")||team.getDay().equals("Sonday")||team.getDay().equals("Sunday")||team.getDay().equals("sunday") ||team.getDay().equals("saturday")||team.getDay().equals("saturday") ||team.getDay().equals("friday") ||team.getDay().equals("thursday")||team.getDay().equals("wednesday")||team.getDay().equals("tuesday") || team.getDay().equals("monday")  
				) {return teamRepo.save(team);
			 }
		
		
		
		else {
			result.rejectValue("day","g","invalid day!!");return null;
			
		}
	}
	public void deleteTeam(Long id) {
		teamRepo.deleteById(id);
	}
	
	public Team singleTeam(Long id) {
		Optional<Team> optTeam = teamRepo.findById(id);
		if(optTeam.isPresent()) {
			return optTeam.get();
		}else {
			return null;
		}
	}

	public Team updateTeam(Team team) {
		return teamRepo.save(team);
		
	}

}
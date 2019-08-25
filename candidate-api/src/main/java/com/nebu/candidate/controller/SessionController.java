package com.nebu.candidate.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nebu.candidate.entity.Session;
import com.nebu.candidate.repository.SessionRepository;

@RestController
@RequestMapping(path = "/session")
public class SessionController {
	
	@Autowired
	private SessionRepository sessionRepository;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<Session> getSessions(){
		return sessionRepository.findAll();
	}
	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public List<Session> test(){
		
		LocalDateTime lower = LocalDateTime.of(LocalDate.of(2014, 2, 3), LocalTime.of(0, 0));
		LocalDateTime upper = LocalDateTime.of(LocalDate.of(2014, 2, 4), LocalTime.of(23, 59));
		
		List<Session> sessions = sessionRepository.findBySessionStartGreaterThanEqualAndSessionEndLessThanEqual(lower, upper);
		
		return sessions;
		
	}
	
}

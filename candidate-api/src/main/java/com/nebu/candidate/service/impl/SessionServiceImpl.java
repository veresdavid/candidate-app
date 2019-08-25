package com.nebu.candidate.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nebu.candidate.dto.SessionDTO;
import com.nebu.candidate.entity.Session;
import com.nebu.candidate.repository.SessionRepository;
import com.nebu.candidate.service.SessionService;

@Service
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<SessionDTO> getAll() {
		
		List<Session> sessions = sessionRepository.findAll();
		
		List<SessionDTO> result = new ArrayList<SessionDTO>();
		
		for(Session session : sessions) {
			result.add(objectMapper.convertValue(session, SessionDTO.class));
		}
		
		return result;
		
	}

	@Override
	public List<SessionDTO> getSessionsWithBounds(LocalDateTime lower, LocalDateTime upper) {
		
		List<Session> sessions = sessionRepository.findBySessionStartGreaterThanEqualAndSessionEndLessThanEqual(lower, upper);
		
		List<SessionDTO> result = new ArrayList<SessionDTO>();
		
		for(Session session : sessions) {
			result.add(objectMapper.convertValue(session, SessionDTO.class));
		}
		
		return result;
		
	}

}

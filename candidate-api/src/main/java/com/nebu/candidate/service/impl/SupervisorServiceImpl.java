package com.nebu.candidate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nebu.candidate.dto.SupervisorDTO;
import com.nebu.candidate.entity.Supervisor;
import com.nebu.candidate.repository.SupervisorRepository;
import com.nebu.candidate.service.SupervisorService;

@Service
public class SupervisorServiceImpl implements SupervisorService {
	
	@Autowired
	private SupervisorRepository supervisorRepository;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<SupervisorDTO> getAll() {
		
		List<Supervisor> supervisors = supervisorRepository.findAll();
		
		List<SupervisorDTO> result = new ArrayList<SupervisorDTO>();
		
		for(Supervisor supervisor : supervisors) {
			result.add(objectMapper.convertValue(supervisor, SupervisorDTO.class));
		}
		
		return result;
		
	}

	@Override
	public SupervisorDTO getSupervisorById(long id) {
		
		return objectMapper.convertValue(supervisorRepository.findById(id), SupervisorDTO.class);
		
	}

}

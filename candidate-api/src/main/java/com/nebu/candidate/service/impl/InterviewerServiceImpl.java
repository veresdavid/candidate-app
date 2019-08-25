package com.nebu.candidate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nebu.candidate.dto.InterviewerDTO;
import com.nebu.candidate.entity.Interviewer;
import com.nebu.candidate.repository.InterviewerRepository;
import com.nebu.candidate.service.InterviewerService;

@Service
public class InterviewerServiceImpl implements InterviewerService {
	
	@Autowired
	private InterviewerRepository interviewerRepository;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<InterviewerDTO> getAll() {
		
		List<Interviewer> interviewers = interviewerRepository.findAll();
		
		List<InterviewerDTO> result = new ArrayList<InterviewerDTO>();
		
		for(Interviewer interviewer : interviewers) {
			result.add(objectMapper.convertValue(interviewer, InterviewerDTO.class));
		}
		
		return result;
		
	}

	@Override
	public InterviewerDTO getInterviewerById(long id) {
		
		return objectMapper.convertValue(interviewerRepository.findById(id), InterviewerDTO.class);
		
	}

}

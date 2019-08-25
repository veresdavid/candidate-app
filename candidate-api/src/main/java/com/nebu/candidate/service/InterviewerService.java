package com.nebu.candidate.service;

import java.util.List;

import com.nebu.candidate.dto.InterviewerDTO;

public interface InterviewerService {
	
	List<InterviewerDTO> getAll();
	
	InterviewerDTO getInterviewerById(long id);

}

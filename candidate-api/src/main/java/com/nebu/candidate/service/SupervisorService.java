package com.nebu.candidate.service;

import java.util.List;

import com.nebu.candidate.dto.SupervisorDTO;

public interface SupervisorService {
	
	List<SupervisorDTO> getAll();
	
	SupervisorDTO getSupervisorById(long id);

}

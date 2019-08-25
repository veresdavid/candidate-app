package com.nebu.candidate.service;

import java.time.LocalDateTime;
import java.util.List;

import com.nebu.candidate.dto.SessionDTO;

public interface SessionService {

	List<SessionDTO> getAll();
	
	List<SessionDTO> getSessionsWithBounds(LocalDateTime lower, LocalDateTime upper);
	
}

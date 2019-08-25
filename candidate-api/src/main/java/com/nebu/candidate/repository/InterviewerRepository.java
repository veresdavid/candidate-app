package com.nebu.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nebu.candidate.entity.Interviewer;

public interface InterviewerRepository extends JpaRepository<Interviewer, Long> {
	
	Interviewer findById(long id);

}

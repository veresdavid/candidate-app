package com.nebu.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nebu.candidate.entity.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {

	Supervisor findById(long id);
	
}

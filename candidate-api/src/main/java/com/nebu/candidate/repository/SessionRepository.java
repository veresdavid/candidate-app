package com.nebu.candidate.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nebu.candidate.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

	List<Session> findBySessionStartGreaterThanEqualAndSessionEndLessThanEqual(LocalDateTime lowerBound, LocalDateTime upperBound);
	
}

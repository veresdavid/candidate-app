package com.nebu.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nebu.candidate.entity.HourType;

public interface HourTypeRepository extends JpaRepository<HourType, Long> {

}

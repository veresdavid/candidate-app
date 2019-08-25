package com.nebu.candidate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nebu.candidate.dto.HourTypeDTO;
import com.nebu.candidate.entity.HourType;
import com.nebu.candidate.repository.HourTypeRepository;
import com.nebu.candidate.service.HourTypeService;

@Service
public class HourTypeServiceImpl implements HourTypeService {

	@Autowired
	private HourTypeRepository hourTypeRepository;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<HourTypeDTO> getAll() {
		
		List<HourType> hourTypes = hourTypeRepository.findAll();
		
		List<HourTypeDTO> result = new ArrayList<HourTypeDTO>();
		
		for(HourType hourType : hourTypes) {
			result.add(objectMapper.convertValue(hourType, HourTypeDTO.class));
		}
		
		return result;
		
	}

}

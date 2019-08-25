package com.nebu.candidate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nebu.candidate.dto.HourTypeDTO;
import com.nebu.candidate.service.HourTypeService;

@RestController
@RequestMapping(path = "/hourType")
public class HourTypeController {
	
	@Autowired
	private HourTypeService hourTypeService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<HourTypeDTO> getAll(){
		
		return hourTypeService.getAll();
		
	}
	
}

package com.nebu.candidate.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class InterviewerDTO {
	
	private long id;
	
	private String name;
	
	private double hourlyRate;
	
	private long supervisorId;

}

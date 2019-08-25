package com.nebu.candidate.dto.report;

import java.util.List;

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
public class ReportInterviewerDTO {
	
	private long id;
	
	private String name;
	
	private double hourlyRate;
	
	private double sum;
	
	private List<ReportSessionDTO> sessions;

}

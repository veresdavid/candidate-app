package com.nebu.candidate.dto;

import java.time.LocalDateTime;

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
public class SessionDTO {
	
	private long interviewerId;
	
	private long hourTypeId;
	
	private LocalDateTime sessionStart;
	
	private LocalDateTime sessionEnd;

}

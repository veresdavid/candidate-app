package com.nebu.candidate.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Session", schema = "dbo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Session {
	
	@EmbeddedId
	@JsonIgnore
	private SessionId id;
	
	@Column(name = "InterviewerId")
	private long interviewerId;
	
	@Column(name = "HourTypeId")
	private long hourTypeId;
	
	@Column(name = "SessionStart")
	private LocalDateTime sessionStart;
	
	@Column(name = "SessionEnd")
	private LocalDateTime sessionEnd;
	
}

package com.nebu.candidate.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SessionId implements Serializable {

	@ManyToOne
    @JoinColumn(name = "InterviewerID")
    private Interviewer interviewerId;


    @ManyToOne
    @JoinColumn(name = "HourTypeID")
    private HourType hourTypeId;
	
}

package com.nebu.candidate.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DateTimeRange {

	private LocalDateTime sessionStart;

	private LocalDateTime sessionEnd;

}
package com.nebu.candidate.dto.report;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ReportSessionDTO {

	private String sessionStart;

	private String sessionEnd;

	private double durationInHours;

	private long hourTypeId;

	private String hourTypeName;

	private double ratio;

	private double value;

}

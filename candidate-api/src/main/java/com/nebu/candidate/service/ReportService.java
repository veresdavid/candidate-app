package com.nebu.candidate.service;

import java.time.LocalDateTime;
import java.util.List;

import com.nebu.candidate.dto.report.ReportSupervisorDTO;

public interface ReportService {

	List<ReportSupervisorDTO> getReportForInterval(LocalDateTime lower, LocalDateTime upper);
	
}

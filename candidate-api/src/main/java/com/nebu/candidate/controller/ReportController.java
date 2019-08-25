package com.nebu.candidate.controller;

import com.nebu.candidate.dto.DateTimeRange;
import com.nebu.candidate.dto.report.ReportSupervisorDTO;
import com.nebu.candidate.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/report")
public class ReportController {

	@Autowired
	private ReportService reportService;

	// TODO: only for dev purposes: enable CORS
	@CrossOrigin
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public List<ReportSupervisorDTO> getReport(@RequestBody DateTimeRange dateTimeRange) {

		return reportService.getReportForInterval(dateTimeRange.getSessionStart(), dateTimeRange.getSessionEnd());

	}

}

package com.nebu.candidate.service.impl;

import com.nebu.candidate.dto.HourTypeDTO;
import com.nebu.candidate.dto.InterviewerDTO;
import com.nebu.candidate.dto.SessionDTO;
import com.nebu.candidate.dto.SupervisorDTO;
import com.nebu.candidate.dto.report.ReportInterviewerDTO;
import com.nebu.candidate.dto.report.ReportSessionDTO;
import com.nebu.candidate.dto.report.ReportSupervisorDTO;
import com.nebu.candidate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private HourTypeService hourTypeService;

	@Autowired
	private InterviewerService interviewerService;

	@Autowired
	private SupervisorService supervisorService;

	@Override
	public List<ReportSupervisorDTO> getReportForInterval(LocalDateTime lower, LocalDateTime upper) {

		// find all sessions for the given time interval
		List<SessionDTO> sessions = null;

		if (lower == null && upper == null) {
			sessions = sessionService.getAll();
		} else {
			sessions = sessionService.getSessionsWithBounds(lower, upper);
		}

		// group sessions by interviewer ids
		Map<Long, List<SessionDTO>> sessionsByInterviewers = groupSessionsByInterviewerIds(sessions);

		// create report interviewer DTOs
		Map<Long, List<ReportInterviewerDTO>> reportInterviewerDTOs = createReportInterviewerDTOMapFromMap(sessionsByInterviewers);

		// create result from map
		List<ReportSupervisorDTO> result = createReportFromMap(reportInterviewerDTOs);

		return result;

	}

	private Map<Long, List<SessionDTO>> groupSessionsByInterviewerIds(List<SessionDTO> sessionDTOs) {

		Map<Long, List<SessionDTO>> result = new HashMap<>();

		for (SessionDTO sessionDTO : sessionDTOs) {

			if (!result.containsKey(sessionDTO.getInterviewerId())) {
				result.put(sessionDTO.getInterviewerId(), new ArrayList<SessionDTO>());
			}

			result.get(sessionDTO.getInterviewerId()).add(sessionDTO);

		}

		return result;

	}

	private Map<Long, List<ReportInterviewerDTO>> createReportInterviewerDTOMapFromMap(Map<Long, List<SessionDTO>> map) {

		Map<Long, List<ReportInterviewerDTO>> result = new HashMap<>();

		// get hour type objects
		List<HourTypeDTO> hourTypeDTOs = hourTypeService.getAll();

		for (Long interviewerId : map.keySet()) {

			// convert the list of sessions to report format
			List<ReportSessionDTO> reportSessionDTOs = new ArrayList<>();

			for (SessionDTO sessionDTO : map.get(interviewerId)) {

				ReportSessionDTO reportSessionDTO = new ReportSessionDTO();

				// get the corresponding hour type object
				// TODO: we hope we have an hour type with the given id
				HourTypeDTO hourTypeDTO = hourTypeDTOs.stream().filter(h -> h.getId() == sessionDTO.getHourTypeId()).collect(Collectors.toList()).get(0);

				// calculate the duration of the session in hours
				long durationInMillis = ChronoUnit.MILLIS.between(sessionDTO.getSessionStart(), sessionDTO.getSessionEnd());
				double durationInHours = durationInMillis / (3600.0 * 1000.0);

				reportSessionDTO.setSessionStart(sessionDTO.getSessionStart().format(DateTimeFormatter.ISO_DATE_TIME));
				reportSessionDTO.setSessionEnd(sessionDTO.getSessionEnd().format(DateTimeFormatter.ISO_DATE_TIME));
				reportSessionDTO.setDurationInHours(durationInHours);
				reportSessionDTO.setHourTypeId(sessionDTO.getHourTypeId());
				reportSessionDTO.setHourTypeName(hourTypeDTO.getHourTypeName());
				reportSessionDTO.setRatio(hourTypeDTO.getRatio());
				reportSessionDTO.setValue(durationInHours * hourTypeDTO.getRatio());

				reportSessionDTOs.add(reportSessionDTO);

			}

			// get the interviewer
			InterviewerDTO interviewerDTO = interviewerService.getInterviewerById(interviewerId);

			// sum the values of sessions
			double sum = 0.0;

			for (ReportSessionDTO reportSessionDTO : reportSessionDTOs) {
				sum += reportSessionDTO.getValue();
			}

			sum *= interviewerDTO.getHourlyRate();

			// construct interviewer object for report
			ReportInterviewerDTO reportInterviewerDTO = new ReportInterviewerDTO();

			reportInterviewerDTO.setId(interviewerId);
			reportInterviewerDTO.setName(interviewerDTO.getName());
			reportInterviewerDTO.setHourlyRate(interviewerDTO.getHourlyRate());
			reportInterviewerDTO.setSum(sum);
			reportInterviewerDTO.setSessions(reportSessionDTOs);

			// add result to the map
			if (!result.containsKey(interviewerDTO.getSupervisorId())) {
				result.put(interviewerDTO.getSupervisorId(), new ArrayList<>());
			}

			result.get(interviewerDTO.getSupervisorId()).add(reportInterviewerDTO);

		}

		return result;

	}

	private List<ReportSupervisorDTO> createReportFromMap(Map<Long, List<ReportInterviewerDTO>> map) {

		List<ReportSupervisorDTO> result = new ArrayList<>();

		for (long supervisorId : map.keySet()) {

			// get supervisor data
			SupervisorDTO supervisorDTO = supervisorService.getSupervisorById(supervisorId);

			// collect sum
			double sum = 0.0;

			for (ReportInterviewerDTO reportInterviewerDTO : map.get(supervisorId)) {
				sum += reportInterviewerDTO.getSum();
			}

			// create new report supervisor object
			ReportSupervisorDTO reportSupervisorDTO = new ReportSupervisorDTO();

			reportSupervisorDTO.setId(supervisorId);
			reportSupervisorDTO.setName(supervisorDTO.getName());
			reportSupervisorDTO.setSum(sum);
			reportSupervisorDTO.setInterviewers(map.get(supervisorId));

			// add object to list
			result.add(reportSupervisorDTO);

		}

		return result;

	}

}

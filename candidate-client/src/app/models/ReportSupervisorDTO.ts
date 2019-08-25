import { ReportInterviewerDTO } from "./ReportInterviewerDTO";

export class ReportSupervisorDTO {

	id: Number;
	name: String;
	sum: Number;
	interviewers: ReportInterviewerDTO[];

	constructor(obj: any) {

		Object.assign(this, obj);

		let interviewers = [];
		for(let interviewer of obj.interviewers) {
			let parsedInterviewer = new ReportInterviewerDTO(interviewer);
			interviewers.push(parsedInterviewer);
		}

		this.interviewers = interviewers;

	}

}
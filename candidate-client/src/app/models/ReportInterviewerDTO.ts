import { ReportSessionDTO } from "./ReportSessionDTO";

export class ReportInterviewerDTO {

	id: Number;
	name: String;
	hourlyRate: Number;
	sum: Number;
	sessions: ReportSessionDTO[];

	constructor(obj: any) {

		Object.assign(this, obj);

		let sessions = [];
		for(let session of obj.sessions) {
			let parsedSession = new ReportSessionDTO(session);
			sessions.push(parsedSession);
		}

		this.sessions = sessions;

	}

}
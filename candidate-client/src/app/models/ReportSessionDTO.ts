export class ReportSessionDTO {

	sessionStart: Date;
	sessionEnd: Date;
	durationInHours: Number;
	hourTypeId: Number;
	hourTypeName: String;
	ratio: Number;
	value: Number;

	constructor(obj: any) {

		Object.assign(this, obj);

		this.sessionStart = new Date(obj.sessionStart);
		this.sessionEnd = new Date(obj.sessionEnd);

	}

}
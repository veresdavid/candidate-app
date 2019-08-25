import { Component, OnInit } from '@angular/core';

import { ReportService } from "./services/report.service";

import { ReportSupervisorDTO } from "./models/ReportSupervisorDTO";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  dateTimeStart: Date;
  dateTimeEnd: Date;
  report: ReportSupervisorDTO[];

  constructor(private reportService: ReportService) {
    this.dateTimeStart = null;
    this.dateTimeEnd = null;
    this.report = [];
  }

  ngOnInit() {
    this.getReport();
  }

  getReport(): void {
    this.reportService.getReport(this.dateTimeStart, this.dateTimeEnd)
      .subscribe(report => { this.report = report; console.log(report); });
  }

  search(): void {
    this.getReport();
  }

  reset(): void {
    this.dateTimeStart = null;
    this.dateTimeEnd = null;
    this.getReport();
  }

}

import { Component, OnInit, Input } from '@angular/core';

import { ReportInterviewerDTO } from "../models/ReportInterviewerDTO";

@Component({
  selector: 'app-interviewer',
  templateUrl: './interviewer.component.html',
  styleUrls: ['./interviewer.component.css']
})
export class InterviewerComponent implements OnInit {

  @Input()
  interviewer: ReportInterviewerDTO;

  isCollapsed: boolean;

  constructor() {
    this.isCollapsed = true;
  }

  ngOnInit() {
  }

}

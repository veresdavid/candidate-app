import { Component, OnInit, Input } from '@angular/core';

import { ReportSupervisorDTO } from "../models/ReportSupervisorDTO";

@Component({
  selector: 'app-supervisor',
  templateUrl: './supervisor.component.html',
  styleUrls: ['./supervisor.component.css']
})
export class SupervisorComponent implements OnInit {

  @Input()
  supervisor: ReportSupervisorDTO;

  constructor() { }

  ngOnInit() { }

}

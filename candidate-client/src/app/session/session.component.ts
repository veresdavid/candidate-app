import { Component, OnInit, Input } from '@angular/core';

import { ReportSessionDTO } from "../models/ReportSessionDTO";

@Component({
  selector: 'app-session',
  templateUrl: './session.component.html',
  styleUrls: ['./session.component.css']
})
export class SessionComponent implements OnInit {

  @Input()
  session: ReportSessionDTO;

  constructor() { }

  ngOnInit() {
  }

}

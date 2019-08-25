import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";

import { Observable } from "rxjs";
import { map } from "rxjs/operators";

import { ReportSupervisorDTO } from "../models/ReportSupervisorDTO";

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  private reportUrl = "http://localhost:8080/report/";

  constructor(private http: HttpClient) { }

  getReport(sessionStart: Date, sessionEnd: Date): Observable<ReportSupervisorDTO[]> {

    let requestBody = {
      sessionStart: sessionStart ? sessionStart.toISOString() : null,
      sessionEnd: sessionEnd ? sessionEnd.toISOString() : null
    };

    return this.http.post<ReportSupervisorDTO[]>(this.reportUrl, requestBody)
      .pipe(
        map(response => response.map(element => new ReportSupervisorDTO(element)))
      );
  }

}

import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { Technology } from "../models/technology";
import { GlobalConstants } from "../common/global-constants";

const prefix = GlobalConstants.prefix;

@Injectable({
  providedIn: 'root'
})

export class TechnologyService {

  readonly urlTechnology: string = prefix + "/api/v1/public/technologies";

  constructor(private http: HttpClient) { }

  getAll(): Observable<Technology[]> {
    return this.http.get<Technology[]>(this.urlTechnology);
  }
}

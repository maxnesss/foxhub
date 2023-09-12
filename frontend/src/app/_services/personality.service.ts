import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Personality } from "../models/personality";
import { GlobalConstants } from "../common/global-constants";

const prefix = GlobalConstants.prefix;

@Injectable({
  providedIn: 'root'
})

export class PersonalityService {
  readonly urlPersonalities: string = prefix + "/api/v1/public/personalities";
  constructor(private http: HttpClient) { }

  getAll(): Observable<Personality[]> {
    return this.http.get<Personality[]>(this.urlPersonalities);
  }
}

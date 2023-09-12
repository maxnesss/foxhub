import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { ColorPersonality } from "../models/colorPersonality";
import { GlobalConstants } from "../common/global-constants";

const prefix = GlobalConstants.prefix;

@Injectable({
  providedIn: 'root'
})
export class ColorPersonalityService {
  readonly urlColorPersonalities: string = prefix + "/api/v1/public/colorPersonalities";
  constructor(private http: HttpClient) { }

  getAll(): Observable<ColorPersonality[]> {
    return this.http.get<ColorPersonality[]>(this.urlColorPersonalities);
  }
}



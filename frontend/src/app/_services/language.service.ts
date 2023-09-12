import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { Language } from "../models/language";
import { HttpClient } from "@angular/common/http";
import { GlobalConstants } from "../common/global-constants";

const prefix = GlobalConstants.prefix;

@Injectable({
  providedIn: 'root'
})

export class LanguageService {

  readonly urlLanguage: string = prefix + "/api/v1/public/languages";
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Language[]> {
    return this.http.get<Language[]>(this.urlLanguage);
  }
}

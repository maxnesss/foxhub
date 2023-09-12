import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { User } from "../models/user";
import { Observable } from "rxjs";
import { GlobalConstants } from "../common/global-constants";

const prefix = GlobalConstants.prefix;

@Injectable({
  providedIn: 'root'
})

export class ProfileService {

  private apiUrl: string = prefix + "/api/v1/public/people/";

  constructor(private http: HttpClient) {
  }

  getUser(username: string | null): Observable<User> {
    return this.http.get<User>(this.apiUrl + username);
  }
}

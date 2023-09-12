import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Location} from "../models/location";
import { HttpClient } from "@angular/common/http";
import { GlobalConstants } from "../common/global-constants";

const prefix = GlobalConstants.prefix;

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  readonly urlLocation: string = prefix + "/api/v1/public/locations";
  constructor(private http: HttpClient) { }


  getAll(): Observable<Location[]> {
    return this.http.get<Location[]>(this.urlLocation);
  }
}

import { GlobalConstants } from "../common/global-constants";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { SpiritAnimal } from "../models/spiritAnimal";

const prefix = GlobalConstants.prefix;

@Injectable({
  providedIn: 'root'
})

export class SpiritAnimalService {
  readonly urlSpiritAnimal: string = prefix + "/api/v1/public/spiritAnimals";
  constructor(private http: HttpClient) { }

  getAll(): Observable<SpiritAnimal[]> {
    return this.http.get<SpiritAnimal[]>(this.urlSpiritAnimal);
  }
}

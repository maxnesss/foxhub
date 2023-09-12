import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { User } from "../../models/user";
import { Language } from "../../models/language";
import { Technology } from "../../models/technology";
import { Location } from "../../models/location";
import { Personality } from "../../models/personality";
import { GlobalConstants } from "../../common/global-constants";
import { Router } from "@angular/router";
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import { ColorPersonality } from 'src/app/models/colorPersonality';
import { SpiritAnimal } from 'src/app/models/spiritAnimal';

const prefix = GlobalConstants.prefix;

const httpOptions = {
  headers: new HttpHeaders({ 'Content-type': 'application/json' })
}

@Injectable({
  providedIn: 'root'
})

export class ApiService {

  private apiUrlGetAll: string = prefix + "/api/v1/public/people";

  constructor(private http: HttpClient, private router: Router) {
  }

  getAll(): Observable<User[]> {
    return this.http.get<User[]>(this.apiUrlGetAll).pipe(
      catchError(error => {
        console.error('An error occurred while fetching all users:', error);
        return of([]);
      })
    );
  }

  getUserBasicInfo(): Observable<User> {
    return this.http.get<User>(prefix + '/api/v1/user/person');
  }

  deleteUser(): Observable<any> {
    return this.http.delete(prefix + '/api/v1/user/people');
  }

  removeUser(nickname: string | undefined): void {
    this.http.delete(prefix + '/api/v1/admin/people/' + nickname).subscribe(next => {
      window.location.href = "admin-board"
    });
  }

  search(user: any, key: string, results: any[]) {
    let hasTechnologyMatch = false;

    // @ts-ignore
    for (const technology of user.technologies) {
      if (technology.name.toLowerCase().includes(key.toLowerCase())) {
        results.push(user);
        hasTechnologyMatch = true;
        break;
      }
    }

    if (!hasTechnologyMatch) {
      if (
        user.firstName.toLowerCase().includes(key.toLowerCase()) ||
        user.lastName.toLowerCase().includes(key.toLowerCase())
      ) {
        results.push(user);
      }
    }
  }

  updateUser(firstName: string,
    lastName: string,
    phone: string | undefined,
    locations: Location[] | undefined,
    oneLineAbout: string | undefined,
    workPreference: string | undefined,
    about: string | undefined,
    gitHub: string | undefined,
    linkedin: string | undefined,
    facebook: string | undefined,
    instagram: string | undefined,
    optionalPage: string | undefined,
    languages: Language[] | undefined,
    technologies: Technology[] | undefined,
    personality: Personality | undefined,
    colorPersonality: ColorPersonality | undefined,
    yearOfBirth: number | undefined,
    spiritAnimal: SpiritAnimal | undefined
  ): Observable<any> {

    return this.http.patch(prefix + "/api/v1/user/people", {
      firstName,
      lastName,
      phone,
      locations,
      oneLineAbout,
      workPreference,
      about,
      gitHub,
      linkedin,
      facebook,
      instagram,
      optionalPage,
      languages,
      technologies,
      personality,
      colorPersonality,
      yearOfBirth,
      spiritAnimal
    },
      httpOptions
    );
  }

  changeRole(nickname: string | undefined) {
    // @ts-ignore
    this.http.post(prefix + '/api/v1/admin/change-role/' + nickname).subscribe(next => {
      window.location.href = "admin-board"
    });
  }

  checkout(message: any) {
    this.http.post(prefix + '/api/v1/public/contact', message, httpOptions).subscribe(() => {
    })
  }
}

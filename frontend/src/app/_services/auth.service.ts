import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from "@angular/common/http";
import { catchError, Observable, throwError } from "rxjs";
import { ToastrService } from 'ngx-toastr';
import { GlobalConstants } from "../common/global-constants";

const prefix = GlobalConstants.prefix;
const AUTH_API = prefix + '/api/v1/auth/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-type': 'application/json' })
}

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  constructor(
    private http: HttpClient,
    private toastr: ToastrService) {
  }

  login(email: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'login',
      {
        email,
        password
      },
      httpOptions
    ).pipe(
      catchError((error: HttpErrorResponse) => {
        let errorMessage = 'An unknown error occurred.';
        if (error.status === 401) {
          errorMessage = error.error;
        }
        this.toastr.error(errorMessage, 'Error', { timeOut: 5000 });
        return throwError(errorMessage);
      })
    );
  }

  register(firstName: string, lastName: string, email: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'register',
      {
        firstName,
        lastName,
        email,
        password
      },
      httpOptions
    ).pipe(
      catchError((error: HttpErrorResponse) => {
        let errorMessage = 'An unknown error occurred.';
        if (error.status === 400) {
          errorMessage = error.error;
        }
        this.toastr.error(errorMessage, 'Error', { timeOut: 5000 });
        return throwError(errorMessage);
      })
    );
  }

  logout(): void {
    this.http.post(
      prefix + '/api/v1/auth/signout',
      {},
      httpOptions
    ).subscribe(ok => {
      this.toastr.error('Successfully Logged Out!', 'Success', { timeOut: 5000 });
    });
  }

  resetPassword(email: String, yearOfBirth: number): Observable<any> {
    return this.http.post(
      prefix + '/api/v1/auth/password-reset',
      {
        email,
        yearOfBirth
      },
      httpOptions
    ).pipe(
      catchError((error: HttpErrorResponse) => {
        let errorMessage = 'An unknown error occurred.';
        if (error.status === 400) {
          errorMessage = error.error;
        }
        this.toastr.error(errorMessage, 'Error', { timeOut: 5000 });
        return throwError(errorMessage);
      })
    );
  }

  changePassword(newPassword: String) {
    return this.http.post(
      prefix + '/api/v1/user/password-change',
      {
        newPassword
      },
      httpOptions
    ).pipe(
      catchError((error: HttpErrorResponse) => {
        let errorMessage = 'An unknown error occurred.';
        if (error.status === 400) {
          errorMessage = error.error;
        }
        this.toastr.error(errorMessage, 'Error', { timeOut: 5000 });
        return throwError(errorMessage);
      })
    );
  }
}

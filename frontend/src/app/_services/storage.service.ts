import { Injectable } from '@angular/core';
import { User } from "../models/user";

const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})

export class StorageService {
  constructor() { }

  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUserFromSession(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return {};
  }

  public isLoggedIn(): boolean {
    return Boolean(window.sessionStorage.getItem(USER_KEY));
  }

  public logout(): void {
    window.sessionStorage.clear();
  }
}

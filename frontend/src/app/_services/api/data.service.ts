import { EventEmitter, Injectable } from '@angular/core';
import { User } from "../../models/user";

@Injectable({
  providedIn: 'root'
})

export class DataService {

  // @ts-ignore
  users: User[];

  constructor() {
  }

}

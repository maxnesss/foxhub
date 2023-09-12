import { Component } from '@angular/core';
import { User } from "../../models/user";
import { ApiService } from "../../_services/api/api.service";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})

export class MainPageComponent {

  // @ts-ignore
  user: User;
  // @ts-ignore
  userRole: string;
  // @ts-ignore
  userFullName: string;
  // @ts-ignore
  userID: number | undefined;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getUserBasicInfo().subscribe((user: User) => {
      this.user = user;
      // @ts-ignore
      this.userRole = user.roles[0].name;
      this.userFullName = user.firstName + ' ' + user.lastName;
      this.userID = user.id;
    });
  }
}


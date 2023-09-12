import {Component, OnInit} from '@angular/core';
import {User} from "../../models/user";
import {ApiService} from "../../_services/api/api.service";

@Component({
  selector: 'app-admin-board',
  templateUrl: './admin-board.component.html',
  styleUrls: ['./admin-board.component.css']
})
export class AdminBoardComponent implements OnInit{
  // @ts-ignore
  users: User[] = [];
  selectedUser: User = {password: "", firstName: "", lastName: "", email: ""};

  constructor(private apiService:ApiService) {
  }

  ngOnInit(): void {
    this.apiService.getAll().subscribe(users => {
      this.users=users;
      this.selectedUser = users[0];
    });
  }

  deleteUser(user:User) {
    this.apiService.removeUser(user.nickname)
  }

  setSelectedUser(user: User) {
    this.selectedUser = user;
  }

  changeRole(user: User) {
    this.apiService.changeRole(user.nickname)

  }
}

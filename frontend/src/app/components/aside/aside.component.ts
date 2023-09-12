import {Component, OnInit} from '@angular/core';
import {User} from "../../models/user";
import {ApiService} from "../../_services/api/api.service";

@Component({
  selector: 'app-aside',
  templateUrl: './aside.component.html',
  styleUrls: ['./aside.component.css']
})

export class AsideComponent implements OnInit {


  verifiedUsers: User[] = [];
  showPeople = false;
  rotationClass = '';

  constructor(private apiService: ApiService) {
  }

  togglePeople(): void {
    this.showPeople = !this.showPeople;
    this.rotationClass = this.showPeople ? 'rotate-up' : 'rotate-down';
  }

  ngOnInit() {
    this.apiService.getAll().subscribe((usersFetch: User[]) => {
      this.verifiedUsers = usersFetch.filter(user => user.verified);
    });
  }
}

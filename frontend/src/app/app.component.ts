import { Component } from '@angular/core';
import { ApiService } from "./_services/api/api.service";
import { DataService } from "./_services/api/data.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'frontend';

  constructor(
    private apiService: ApiService,
    private dataService: DataService,
  ) {
  }

  ngOnInit(): void {
    this.getUsers();
  }

  private getUsers(): void {
    this.apiService
      .getAll().subscribe((users) => {
        this.dataService.users = users;
      }
      );
  }
}

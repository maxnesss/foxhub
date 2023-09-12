import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../_services/auth.service";

@Component({
  selector: 'app-update-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})

export class ResetPasswordComponent implements OnInit {
  form: any = {
    email: null,
    yearOfBirth: null
  };

  isSuccessful = false;
  isResetFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
  }

  public onSubmit() {
    const {email, yearOfBirth} = this.form;
    this.authService.resetPassword(email, yearOfBirth).subscribe({
      next: () => {
        this.isSuccessful = true;
        this.isResetFailed = false;
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isResetFailed = true;
      }
    });
  }
}

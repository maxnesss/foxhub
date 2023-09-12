import {Component} from '@angular/core';
import {AuthService} from "../../_services/auth.service";

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})

export class ChangePasswordComponent {
  form: any = {
    newPassword: null
  };

  isSuccessful = false;
  isResetFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) {
  }

  onSubmit() {
    const {newPassword} = this.form;
    this.authService.changePassword(newPassword).subscribe({
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

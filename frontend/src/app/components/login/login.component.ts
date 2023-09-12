import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { AuthService } from "../../_services/auth.service";
import { StorageService } from "../../_services/storage.service";
import { Router, NavigationEnd } from "@angular/router";
import { ToastrService } from 'ngx-toastr';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: any = {
    email: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  userNickname: string = '';
  showSuccessToast = false;

  constructor(
    private authService: AuthService,
    private storageService: StorageService,
    private router: Router,
    private toastr: ToastrService,
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.userNickname = this.storageService.getUserFromSession();
    }

    this.router.events.pipe(filter(event => event instanceof NavigationEnd)).subscribe((event) => {
      if (this.showSuccessToast) {
        this.toastr.success('Successfully Logged In!', 'Success', { timeOut: 5000 });
        this.showSuccessToast = false;
      }
    });
  }

  onSubmit(): void {
    const { email, password } = this.form;

    this.authService.login(email, password).subscribe({
      next: data => {
        this.storageService.saveUser(data.email);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.showSuccessToast = true;
        this.router.navigate(['/']);
      },
      error: err => {
        this.errorMessage = err.error.message;
        console.log(JSON.stringify(err, null, 2));
        this.isLoginFailed = true;
        this.toastr.error(this.errorMessage, 'Error');
        this.cdr.detectChanges();
      }
    });
  }
}

import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from "../../_services/auth.service";
import { StorageService } from "../../_services/storage.service";
import { User } from "../../models/user";
import { ApiService } from "../../_services/api/api.service";
import { CartService } from "../../_services/cart.service";
import { Subscription } from "rxjs";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit, OnDestroy {

  user: User = { email: "", firstName: "", lastName: "", password: "" };
  isLoggedIn = false;
  isExpanded = false;

  // @ts-ignore
  userRole: string;
  userEmail: string = '';

  // @ts-ignore
  countItems: number = this.cartService.getCartItems().length;

  // @ts-ignore
  private cartItemsSubscription: Subscription;

  constructor(
    private authService: AuthService,
    private storageService: StorageService,
    private apiService: ApiService,
    private cartService: CartService
  ) {

    document.addEventListener("click", (event: Event) => {
      const target = event.target as HTMLElement;
      const contentContainer = document.querySelector(".content-container");
      const navbar = document.querySelector(".navbar");

      if (!(contentContainer?.contains(target) || navbar?.contains(target))) {
        this.isExpanded = false;
      }
    });

  }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.userEmail = this.storageService.getUserFromSession();
      this.apiService.getUserBasicInfo().subscribe((user: User) => {
        this.user = user;
        // @ts-ignore
        this.userRole = user.roles[0].name;
      });
    }
    this.cartItemsSubscription = this.cartService.getCartItemsObservable()
      .subscribe((cartItems: User[]) => {
        this.countItems = cartItems.length;
      });
  }

  ngOnDestroy() {
    this.cartItemsSubscription.unsubscribe();
    
    if (this.cartItemsSubscription) {
      this.cartItemsSubscription.unsubscribe();
    }
  }

  toggleNavbar() {
    this.isExpanded = !this.isExpanded;
  }

  logout(): void {
    this.storageService.logout();
    this.authService.logout();
    this.isLoggedIn = false;
  }
}

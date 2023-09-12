import { Component } from '@angular/core';
import { User } from "../../models/user";
import { ProfileService } from "../../_services/profile.service";
import { ActivatedRoute, Router, NavigationEnd } from '@angular/router';
import { SafeValue } from "@angular/platform-browser";
import { filter } from 'rxjs/operators';
import { StorageService } from "../../_services/storage.service";
import { GlobalConstants } from "../../common/global-constants";
import { CartService } from "../../_services/cart.service";
import { ColorPersonality } from "../../models/colorPersonality";

export interface LocalUser {
  workLocation?: string;
  oneLineAbout?: string;
}
@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})

export class ProfilePageComponent {
  // @ts-ignore
  username: string | null = "";
  userEmail: string = '';
  user: User = { email: "", firstName: "", lastName: "", password: "" };
  qrCodeDownloadLink: SafeValue = "";
  isOpen: boolean = false;
  isLoggedIn: boolean = false;
  prefix: string = GlobalConstants.prefix;
  addedUsers: User[] = this.cartService.getCartItems();
  // @ts-ignore
  private cartItemsSubscription: Subscription;

  constructor(
    private profileService: ProfileService,
    private activatedRoute: ActivatedRoute,
    private storageService: StorageService,
    private cartService: CartService,
    private router: Router
  ) {
    router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(event => {
      this.ngOnInit();
    });

    document.addEventListener("click", (event: Event) => {
      const target = event.target as HTMLElement;
      const linksBox = document.querySelector(".links-box");
      const profileImgContainer = document.querySelector(".profile-img-container");

      if (!linksBox?.contains(target) && !profileImgContainer?.contains(target)) {
        this.isOpen = false;
      }
    })

  }

  ngOnInit() {
    this.username = this.activatedRoute.snapshot.paramMap.get("username");
    this.profileService.getUser(this.username).subscribe(user => {
      this.user = user;
      const cartItems = this.cartService.getCartItems();
      this.user.inCart = cartItems.some((cartUser: User) => cartUser.nickname === this.user.nickname);
    });

    // @ts-ignore
    this.onChangeURL();

    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.userEmail = this.storageService.getUserFromSession();
    }

    this.cartItemsSubscription = this.cartService.getCartItemsObservable()
      .subscribe((cartItems: User[]) => {
        this.addedUsers = cartItems;
      });
  }

  profileImageBorder(colorPersonality: ColorPersonality | undefined): string {
    switch (colorPersonality?.name) {
      case 'Red':
        return '3px solid red';
      case 'Green':
        return '3px solid green';
      case 'Blue':
        return '3px solid blue';
      case 'Yellow':
        return '3px solid #ffc107';
      default:
        return '1px solid transparent';
    }
  }

  ngOnDestroy() {
    this.cartItemsSubscription.unsubscribe();
  }

  toggleSocialLinks() {
    this.isOpen = !this.isOpen;
  }

  onChangeURL(url: SafeValue) {
    this.qrCodeDownloadLink = url;
  }

  addToCart(user: User) {
    this.cartService.addToCart(user);
    this.user.inCart = true;
  }

  removeItem(user: User) {
    this.cartService.removeFromCart(user)
    this.user.inCart = false;
  }

  toggleItem(user: User) {
    this.user.inCart ? this.removeItem(user) : this.addToCart(user);
  }
  protected readonly location = location;
}

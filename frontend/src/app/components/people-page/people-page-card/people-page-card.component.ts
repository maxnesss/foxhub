import {Component, ElementRef, Input, OnDestroy, ViewChild} from '@angular/core';
import {User} from "../../../models/user";
import {CartService} from "../../../_services/cart.service";
import {StorageService} from "../../../_services/storage.service";
import {AuthService} from "../../../_services/auth.service";
import {ColorPersonality} from "../../../models/colorPersonality";

@Component({
  selector: 'app-people-page-card',
  templateUrl: './people-page-card.component.html',
  styleUrls: ['./people-page-card.component.css']
})

export class PeoplePageCardComponent implements OnDestroy {

  // @ts-ignore
  @Input() user: User;
  isLoggedIn = false;

  @ViewChild('audioPlayer', {static: false}) audioPlayer!: ElementRef<HTMLAudioElement>;

  constructor(
    private authService: AuthService,
    private cartService: CartService,
    private storageService: StorageService,
  ) {
  }

  ngOnInit(): void {
    if (this.cartService.getCartItems().find((user: User) => user.nickname === this.user.nickname)) {
      this.user.inCart = true;
    }
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
    }
  }

  profileImageBorder(colorPersonality: ColorPersonality | undefined): string {
    switch (colorPersonality?.name) {
      case 'Red':
        return '4px solid red';
      case 'Green':
        return '4px solid green';
      case 'Blue':
        return '4px solid blue';
      case 'Yellow':
        return '4px solid #ffc107';
      default:
        return '1px solid transparent';
    }
  }

  ngOnDestroy() {
  }

  addToCart(user: User) {
    this.cartService.addToCart(user);
    this.user.inCart = true;
    // const audio: HTMLAudioElement = this.audioPlayer.nativeElement;
    // audio.src = "/assets/audio/gun.mp3";
    // audio.play();
  }

  removeItem(user: User) {
    this.cartService.removeFromCart(user)
    this.user.inCart = false;
  }

  toggleItem(event: Event, user: User) {
    event.stopPropagation();
    this.user.inCart ? this.removeItem(user) : this.addToCart(user);
  }
}

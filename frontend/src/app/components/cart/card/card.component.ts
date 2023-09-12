import { Component, Input } from '@angular/core';
import { User } from "../../../models/user";
import { CartService } from "../../../_services/cart.service";

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})

export class CardComponent {

  // @ts-ignore
  @Input() user: User;

  constructor(private cartService: CartService) { }

  removeItem(user: User) {
    this.cartService.removeFromCart(user)
  }
}

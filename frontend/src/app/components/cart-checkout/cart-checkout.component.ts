import { Component, OnInit } from '@angular/core';
import { User } from "../../models/user";
import { CartService } from "../../_services/cart.service";
import { NgForm } from "@angular/forms";
import { ApiService } from "../../_services/api/api.service";

@Component({
  selector: 'app-cart-checkout',
  templateUrl: './cart-checkout.component.html',
  styleUrls: ['./cart-checkout.component.css']
})
export class CartCheckoutComponent implements OnInit {
  cartItems: User[] = [];
  users: string[] = [];
  message: string = "";

  constructor(private cartService: CartService, private apiService: ApiService) { }

  ngOnInit(): void {
    this.cartItems = this.cartService.getCartItems();
    for (let user of this.cartItems) {
      this.users.push(user.firstName + " " + user.lastName);
    }
  }

  sendForm(form: NgForm) {
    this.message = JSON.stringify(form.value) + "\nWants to contact: " + this.users.toString();
    let message = '';

    for (const key in form.value) {
      if (form.value.hasOwnProperty(key) && key !== 'email') {
        message += `${key}: ${form.value[key]}, `;
      }
    }

    const body = {
      from: form.value.email,
      message: message,
      interestedIn: this.users.toString()
    };

    this.apiService.checkout(body);
  }
}

import { Component, Input } from '@angular/core';
import { User } from "../../../models/user";

@Component({
  selector: 'app-aside-user-card',
  templateUrl: './aside-user-card.component.html',
  styleUrls: ['./aside-user-card.component.css']
})

export class AsideUserCardComponent {

  // @ts-ignore
  @Input() user: User;
}

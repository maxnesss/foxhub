import { Component, Input } from '@angular/core';
import { Personality } from "../../models/personality";

@Component({
  selector: 'app-personality',
  templateUrl: './personality.component.html',
  styleUrls: ['./personality.component.css']
})
export class PersonalityComponent {
  // @ts-ignore
  @Input personality: Personality;
}

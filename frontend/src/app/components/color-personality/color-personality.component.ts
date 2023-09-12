import { Component, Input } from '@angular/core';
import { ColorPersonality } from "../../models/colorPersonality";

@Component({
  selector: 'app-color-personality',
  templateUrl: './color-personality.component.html',
  styleUrls: ['./color-personality.component.css']
})
export class ColorPersonalityComponent {

  // @ts-ignore
  @Input colorPersonality: ColorPersonality;
}

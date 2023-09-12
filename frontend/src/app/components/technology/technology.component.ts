import { Component, Input } from '@angular/core';
import { Technology } from "../../models/technology";

@Component({
  selector: 'app-technologies',
  templateUrl: './technology.component.html',
  styleUrls: ['./technology.component.css']
})

export class TechnologyComponent {
  // @ts-ignore
  @Input() technology: Technology;
}

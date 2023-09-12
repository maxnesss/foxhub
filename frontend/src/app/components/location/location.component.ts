import { Component, Input } from '@angular/core';
import { Location } from "../../models/location";

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})

export class LocationComponent {
  // @ts-ignore
  @Input() location: Location;
}

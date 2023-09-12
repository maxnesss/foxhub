import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Location} from "../../models/location";

@Component({
  selector: 'app-location-button',
  templateUrl: './location-button.component.html',
  styleUrls: ['./location-button.component.css']
})
export class LocationButtonComponent {

  // @ts-ignore
  @Input() location: Location;
  @Input() userLocations: Location[] | undefined;
  @Input() unusedLocations: Location[] | undefined;
  @Output() locationComponentEmitter = new EventEmitter<Location[]>();

  sendLocationsUp() {
    this.locationComponentEmitter.emit(this.userLocations);
  }

  ngOnInit(): void {
    console.log(this.location.name)
  }

  switchLocation() {
    if (this.userLocations?.some(userLocation =>
      userLocation.name === this.location.name)) {
      this.switchLocationFromUserToUnused();
    } else {
      this.switchLocationFromUnusedToUser();
    }
    this.sendLocationsUp();
  }

  switchLocationFromUnusedToUser() {
   //@ts-ignore
    for (const location of this.unusedLocations) {
      if (location.name === this.location.name) {
        this.userLocations?.push(location);
        // @ts-ignore
        const index = this.unusedLocations.indexOf(location);
        if (index !== -1) {
          // @ts-ignore
          this.unusedLocations.splice(index, 1);
        }
        break;
      }
    }
  }

  switchLocationFromUserToUnused() {
    //@ts-ignore
    for (const location of this.userLocations) {
      if (location.name === this.location.name) {
        this.unusedLocations?.push(location);
        // @ts-ignore
        const index = this.userLocations.indexOf(location);
        if (index !== -1) {
          // @ts-ignore
          this.userLocations.splice(index, 1);
        }
        break;
      }
    }
  }
}




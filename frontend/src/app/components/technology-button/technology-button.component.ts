import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Technology } from "../../models/technology";

@Component({
  selector: 'app-technology-button',
  templateUrl: './technology-button.component.html',
  styleUrls: ['./technology-button.component.css']
})

export class TechnologyButtonComponent {

  // @ts-ignore
  @Input() technology: Technology
  @Input() userTechnologies: Technology[] | undefined;
  @Input() unusedTechnologies: Technology[] | undefined;
  @Output() technologyComponentEmitter = new EventEmitter<Technology[]>();

  sendTechnologiesUp() {
    this.technologyComponentEmitter.emit(this.userTechnologies);
  }
  
  switchTechnology() {
    if (this.userTechnologies?.some(userTechnology =>
      userTechnology.name === this.technology.name)) {
      this.switchTechnologyFromUserToUnused();
    } else {
      this.switchTechnologyFromUnusedToUser();
    }
    this.sendTechnologiesUp();
  }

  switchTechnologyFromUnusedToUser() {
    // @ts-ignore
    for (const technology of this.unusedTechnologies) {
      if (technology.name === this.technology.name) {
        this.userTechnologies?.push(technology);
        // @ts-ignore
        const index = this.unusedTechnologies.indexOf(technology);
        if (index !== -1) {
          // @ts-ignore
          this.unusedTechnologies.splice(index, 1);
        }
        break;
      }
    }
  }

  switchTechnologyFromUserToUnused() {
    //@ts-ignore
    for (const technology of this.userTechnologies) {
      if (technology.name === this.technology.name) {
        this.unusedTechnologies?.push(technology);
        // @ts-ignore
        const index = this.userTechnologies.indexOf(technology);
        if (index !== -1) {
          // @ts-ignore
          this.userTechnologies.splice(index, 1);
        }
        break;
      }
    }
  }
}

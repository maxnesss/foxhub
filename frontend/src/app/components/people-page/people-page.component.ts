import {Component, OnInit, ViewChild, ElementRef} from '@angular/core';
import {User} from "../../models/user";
import {Technology} from "../../models/technology";
import {Language} from "../../models/language";
import {Location} from "../../models/location";
import {Personality} from "../../models/personality";
import {ColorPersonality} from 'src/app/models/colorPersonality';
import {SpiritAnimal} from "../../models/spiritAnimal";
import {ApiService} from "../../_services/api/api.service";
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-people-page',
  templateUrl: './people-page.component.html',
  styleUrls: ['./people-page.component.css']
})

export class PeoplePageComponent implements OnInit {
  @ViewChild('customRange3', {static: true}) rangeInputRef!: ElementRef<HTMLInputElement>;
  @ViewChild('rangeValue', {static: true}) rangeValueRef!: ElementRef<HTMLSpanElement>;

  // @ts-ignore
  users: User[] = [];
  addedUsers: User[] = [];
  verifiedAndUsersOnly: User[] = [];
  nonFilteredUsers: User[] = [];
  filteredUsersRest: User[]= [];

  usedTechnologies: Technology[] = [];
  usedLanguages: Language[] = [];
  usedPersonalities: Personality[] = [];
  usedColorPersonalities: ColorPersonality[] = [];
  usedLocations: Location[] = [];
  usedSpiritAnimals: SpiritAnimal[] = [];

  selectedTechnologies: string[] = [];
  selectedLanguages: string[] = [];
  selectedPersonalities: string[] = [];
  selectedColorPersonalities: string[] = [];
  selectedLocations: string[] = [];
  selectedSpiritAnimals: string[] = [];

  // @ts-ignore
  filterWorkPrefermentStatus: string;

  actualTechnologyValue: string[] = [];
  actualLanguageValue: string[] = [];
  actualPersonalityValue: string[] = [];
  actualColorPersonalityValue: string[] = [];
  actualWorkPrefermentValue: string = "";
  actualLocationValue: string[] = [];
  actualSpiritAnimalValue: string[] = [];

  restPersonalityFilter: User[] = [];
  restColorPersonalityFilter: User[] = [];
  restWorkPrefermentFilter: User[] = [];
  restLanguageFilter: User[] = [];
  restTechnologiesFilter: User[] = [];
  restLocationFilter: User[] = [];
  restSpiritAnimalFilter: User[] = [];

  public showCookiePopup = false;

  constructor(
    private apiService: ApiService,
    private cookieService: CookieService,) {
  }

  ngOnInit(): void {
    this.filterWorkPrefermentStatus = "all";
    this.showCookiePopup = this.cookieService.get('cookie_consent') !== 'true';

    // @ts-ignore
    this.apiService.getAll().subscribe(users => {
      this.users = users.filter((user: User) => user.verified && user.role?.name === "USER");
      this.verifiedAndUsersOnly = users.filter((user: User) => user.verified && user.role?.name === "USER");
      this.nonFilteredUsers = this.verifiedAndUsersOnly;
      this.usedTechnologiesList();
      this.usedLanguagesList();
      this.usedPersonalitiesList();
      this.usedColorPersonalitiesList();
      this.usedLocationsList();
      this.usedSpiritAnimalsList();
      for (let user of this.users) {
        if (this.addedUsers.includes(user)) {
          user.inCart = true;
        }
      }
    });
  }

  acceptCookies() {
    this.cookieService.set('cookie_consent', 'true');
    this.showCookiePopup = false;
  }

  declineCookies() {
    this.cookieService.delete('cookie_consent');
    this.showCookiePopup = false;
  }

  // @ts-ignore
  get filteredUsersRestFour(){
    // @ts-ignore
    this.filteredUsersRest = this.nonFilteredUsers.filter(user => user.outOfFilters?.length > 4);
  }

  usedTechnologiesList() {
    const usedTechNames: string[] = [];
    for (let user of this.users) {
      // @ts-ignore
      for (let tech of user.technologies) {
        const techName = tech.name.toLowerCase();
        if (!usedTechNames.includes(techName)) {
          usedTechNames.push(techName);
          this.usedTechnologies.push(tech);
        }
      }
    }
  }

  usedLocationsList() {
    const usedLocationsNames: string[] = [];
    for (let user of this.users) {
      // @ts-ignore
      for (let location of user.locations) {
        const locationName = location.name.toLowerCase();
        if (!usedLocationsNames.includes(locationName)) {
          usedLocationsNames.push(locationName);
          // @ts-ignore
          this.usedLocations.push(location);
        }
      }
    }
  }

  // @ts-ignore
  usedLanguagesList(){
    const usedLangNames: string[] = [];
    for (let user of this.users) {
      // @ts-ignore
      for (let lang of user.languages) {
        const langName = lang.name.toLowerCase();
        if (!usedLangNames.includes(langName)) {
          usedLangNames.push(langName);
          this.usedLanguages.push(lang);
        }
      }
    }
  }

  // @ts-ignore
  usedPersonalitiesList(){
    const usedPersNames: string[] = [];
    for (let user of this.users) {
      const persName = user.personality?.name.toLowerCase();
      if (!usedPersNames.includes(<string>persName)) {
        if (persName != null) {
          usedPersNames.push(persName);
        }
        if (user.personality) {
          this.usedPersonalities.push(user.personality);
        }
      }
    }
  }

  // @ts-ignore
  usedColorPersonalitiesList(){
    const usedColorPersonalityIds: number[] = [];
    this.usedColorPersonalities = [];
    for (let user of this.users) {
      const colorPersonalityId = user.colorPersonality?.id;
      if (colorPersonalityId && !usedColorPersonalityIds.includes(colorPersonalityId)) {
        usedColorPersonalityIds.push(colorPersonalityId);
        this.usedColorPersonalities.push(user.colorPersonality!);
      }
    }
    return this.usedColorPersonalities;
  }

  usedSpiritAnimalsList(){
    const usedAnimalsNames: string[] = [];
    for (let user of this.users) {
      const animalName = user.spiritAnimal?.name.toLowerCase();
      if (!usedAnimalsNames.includes(<string>animalName)) {
        if (animalName != null) {
          usedAnimalsNames.push(animalName);
        }
        if (user.spiritAnimal){
          this.usedSpiritAnimals.push(user.spiritAnimal);
        }
      }
    }
  }

  onWorkStatusChange() {
    this.allFilters();
  }

  toggleTechSelection(tech: Technology) {
    const techName = tech.name;
    const techIndex = this.selectedTechnologies.indexOf(techName);
    if (techIndex === -1) {
      this.selectedTechnologies.push(techName);
    } else {
      this.selectedTechnologies.splice(techIndex, 1);
    }
    this.allFilters();
  }

  isSelectedTech(tech: Technology): boolean {
    return this.selectedTechnologies.includes(tech.name);
  }

  toggleLangSelection(lang: Language) {
    const langName = lang.name;
    const langIndex = this.selectedLanguages.indexOf(langName);
    if (langIndex === -1) {
      this.selectedLanguages.push(langName);
    } else {
      this.selectedLanguages.splice(langIndex, 1);
    }
    this.allFilters();
  }

  isSelectedLang(lang: Language): boolean {
    return this.selectedLanguages.includes(lang.name);
  }

  toggleLocationSelection(location: Location) {
    const locationName = location.name;
    const locationIndex = this.selectedLocations.indexOf(locationName);
    if (locationIndex === -1) {
      this.selectedLocations.push(locationName);
    } else {
      this.selectedLocations.splice(locationIndex, 1);
    }
    this.allFilters();
  }

  isSelectedLocation(location: Location): boolean {
    return this.selectedLocations.includes(location.name);
  }


  addToPersonalitiesList(pers: string) {
    if (!this.selectedPersonalities.includes(pers)) {
      this.selectedPersonalities.push(pers);
    } else {
      const index = this.selectedPersonalities.indexOf(pers);
      if (index > -1) {
        this.selectedPersonalities.splice(index, 1);
      }
    }
    this.allFilters();
  }

  addToColorPersonalitiesList(colorPersonality: string) {
    if (!this.selectedColorPersonalities.includes(colorPersonality)) {
      this.selectedColorPersonalities.push(colorPersonality);
    } else {
      const index = this.selectedColorPersonalities.indexOf(colorPersonality);
      if (index > -1) {
        this.selectedColorPersonalities.splice(index, 1);
      }
    }
    this.allFilters();
  }

  addToSpiritAnimalsList(animal: string) {
    if (!this.selectedSpiritAnimals.includes(animal)) {
      this.selectedSpiritAnimals.push(animal);
    } else {
      const index = this.selectedSpiritAnimals.indexOf(animal);
      if (index > -1) {
        this.selectedSpiritAnimals.splice(index, 1);
      }
    }
    this.allFilters();
  }


  // @ts-ignore
  technologiesFilter(users, keys: string[]) {
    const lowerCaseKeys = keys.map(key => key.toLowerCase());
    this.restTechnologiesFilter = [];
    // @ts-ignore
    const actualFilteredUsers = users.filter(user =>
      lowerCaseKeys.every(key =>
        // @ts-ignore
        user.technologies?.some(technology => technology.name.toLowerCase() === key)
      )
    );
    this.actualTechnologyValue = keys;
    this.restTechnologiesFilter = this.verifiedAndUsersOnly
      .filter(user => !actualFilteredUsers.includes(user));
    return actualFilteredUsers;
  }

  // @ts-ignore
  languagesFilter(users: User[], keys: string[]): User[] {
    const lowerCaseKeys = keys.map(key => key.toLowerCase());
    this.restLanguageFilter = [];
    // @ts-ignore
    const actualFilteredUsers = users.filter(user =>
      lowerCaseKeys.every(key =>
        // @ts-ignore
        user.languages?.some(language => language.name.toLowerCase() === key)
      )
    );
    this.actualLanguageValue = keys;
    this.restLanguageFilter = this.verifiedAndUsersOnly
      .filter(user => !actualFilteredUsers.includes(user));
    return actualFilteredUsers;
  }

  // @ts-ignore
  locationsFilter(users: User[], keys: string[]): User[] {
    const lowerCaseKeys = keys.map(key => key.toLowerCase());
    this.restLocationFilter = [];
    // @ts-ignore
    const actualFilteredUsers = users.filter(user =>
      lowerCaseKeys.every(key =>
        // @ts-ignore
        user.locations?.some(location => location.name.toLowerCase() === key)
      )
    );
    this.actualLocationValue = keys;
    this.restLocationFilter = this.verifiedAndUsersOnly
      .filter(user => !actualFilteredUsers.includes(user));
    return actualFilteredUsers;
  }

  personalitiesFilter(users: User[], keys: string[]): User[] {
    const lowerCaseKeys = keys.map(key => key.toLowerCase());
    this.restPersonalityFilter = [];

    const actualFilteredUsers = users.filter(user =>
      lowerCaseKeys.every(key =>
        user.personality?.name.toLowerCase() === key
      )
    );

    this.actualPersonalityValue = keys;
    this.restPersonalityFilter = this.verifiedAndUsersOnly
      .filter(user => !actualFilteredUsers.includes(user));
    return actualFilteredUsers;
  }

  colorPersonalitiesFilter(users: User[], keys: string[]): User[] {
    const lowerCaseKeys = keys.map(key => key.toLowerCase());
    this.restColorPersonalityFilter = [];

    const actualFilteredUsers = users.filter(user =>
      lowerCaseKeys.every(key =>
        user.colorPersonality?.name.toLowerCase() === key
      )
    );

    this.actualColorPersonalityValue = keys;
    this.restColorPersonalityFilter = this.verifiedAndUsersOnly
      .filter(user => !actualFilteredUsers.includes(user));
    return actualFilteredUsers;
  }

  spiritAnimalsFilter(users: User[], keys: string[]): User[] {
    const lowerCaseKeys = keys.map(key => key.toLowerCase());
    this.restSpiritAnimalFilter = [];
    const actualFilteredUsers = users.filter(user =>
      lowerCaseKeys.every(key =>
        user.spiritAnimal?.name.toLowerCase() === key
      )
    );
    this.actualSpiritAnimalValue = keys;
    this.restSpiritAnimalFilter = this.verifiedAndUsersOnly
      .filter(user => !actualFilteredUsers.includes(user));
    return actualFilteredUsers;
  }

  workPrefermentFilter(users: User[]) {
    const actualFilteredUsers: User[] = [];
    this.restWorkPrefermentFilter = [];

    for (let user of users) {
      if (this.filterWorkPrefermentStatus === "combined" && user.workPreference === "COMBINED") {
        actualFilteredUsers.push(user);
      }
      if (this.filterWorkPrefermentStatus === "office" && user.workPreference === "OFFICE") {
        actualFilteredUsers.push(user);
      }
      if (this.filterWorkPrefermentStatus === "remote" && user.workPreference === "REMOTE") {
        actualFilteredUsers.push(user);
      }
      if (this.filterWorkPrefermentStatus === "all") {
        actualFilteredUsers.push(user)
      }
    }

    if (this.filterWorkPrefermentStatus === "combined") {
      this.actualWorkPrefermentValue = "combined"
    } else if (this.filterWorkPrefermentStatus === "office") {
      this.actualWorkPrefermentValue = "office"
    } else if (this.filterWorkPrefermentStatus === "remote") {
      this.actualWorkPrefermentValue = "remote"
    } else {
      this.actualWorkPrefermentValue = "all"
    }
    this.restWorkPrefermentFilter = this.verifiedAndUsersOnly
      .filter(user => !actualFilteredUsers.includes(user));
    return actualFilteredUsers;
  }


  allFilters() {
    let filteredUsers = [...this.verifiedAndUsersOnly];

    filteredUsers = this.workPrefermentFilter(filteredUsers);


    if (this.selectedTechnologies.length > 0) {
      filteredUsers = this.technologiesFilter(filteredUsers, this.selectedTechnologies);
    } else {
      this.actualTechnologyValue = [];
      this.restTechnologiesFilter = [];
    }

    if (this.selectedLanguages.length > 0) {
      filteredUsers = this.languagesFilter(filteredUsers, this.selectedLanguages);
    } else {
      this.actualLanguageValue = [];
      this.restLanguageFilter = [];
    }

    if (this.selectedLocations.length > 0) {
      filteredUsers = this.locationsFilter(filteredUsers, this.selectedLocations);
    } else {
      this.actualLocationValue = [];
      this.restLocationFilter = [];
    }

    if (this.selectedPersonalities.length > 0) {
      filteredUsers = this.personalitiesFilter(filteredUsers, this.selectedPersonalities);
    } else {
      this.actualPersonalityValue = [];
      this.restPersonalityFilter = [];
    }

    if (this.selectedColorPersonalities.length > 0) {
      filteredUsers = this.colorPersonalitiesFilter(filteredUsers, this.selectedColorPersonalities);
    } else {
      this.actualColorPersonalityValue = [];
      this.restColorPersonalityFilter = [];
    }

    if (this.selectedSpiritAnimals.length > 0) {
      filteredUsers = this.spiritAnimalsFilter(filteredUsers, this.selectedSpiritAnimals);
    } else {
      this.actualSpiritAnimalValue = [];
      this.restSpiritAnimalFilter = [];
    }


    for (let user of this.nonFilteredUsers) {
      user.outOfFilters = [];
      if (this.restTechnologiesFilter.includes(user)) {
        for (let tech of this.actualTechnologyValue) {
          if (!user.technologies?.some((userTech) =>
            userTech.name.toLowerCase() === tech.toLowerCase())) {
            user.outOfFilters.push(tech);
          }
        }
      }

      if (this.restLanguageFilter.includes(user)) {
        for (let lang of this.actualLanguageValue) {
          if (!user.languages?.some((userLang) =>
            userLang.name.toLowerCase() === lang.toLowerCase())) {
            user.outOfFilters.push(lang);
          }
        }
      }

      if (this.restLocationFilter.includes(user)) {
        for (let location of this.actualLocationValue) {
          if (!user.locations?.some((userLocation) =>
            userLocation.name.toLowerCase() === location.toLowerCase())) {
            user.outOfFilters.push(location);
          }
        }
      }

      if (this.restPersonalityFilter.includes(user)) {
        for (let pers of this.actualPersonalityValue) {
          if (user.personality?.name.toLowerCase() !== pers.toLowerCase()) {
            user.outOfFilters.push(pers);
          }
        }
      }

      if (this.restColorPersonalityFilter.includes(user)) {
        for (let colorPersonality of this.actualColorPersonalityValue) {
          if (user.colorPersonality?.name.toLowerCase() !== colorPersonality.toLowerCase()) {
            user.outOfFilters.push(colorPersonality);
          }
        }
      }

      if (this.restSpiritAnimalFilter.includes(user)) {
        for (let spiritAnimal of this.actualSpiritAnimalValue) {
          if (user.spiritAnimal?.name.toLowerCase() !== spiritAnimal.toLowerCase()) {
            user.outOfFilters.push(spiritAnimal);
          }
        }
      }

      if (this.actualWorkPrefermentValue !== "all") {
        if (this.restWorkPrefermentFilter.includes(user)) {
          user.outOfFilters.push(this.actualWorkPrefermentValue);
        }
      }
    }
    this.users = filteredUsers;
    this.filteredUsersRestFour;
  }

  clearAllFilters() {
    this.selectedTechnologies = [];
    this.selectedLanguages = [];
    this.filterWorkPrefermentStatus = "all";
    this.selectedPersonalities = [];
    this.selectedColorPersonalities = [];
    this.selectedSpiritAnimals = [];

    for (let user of this.nonFilteredUsers) {
      user.outOfFilters = [];
    }

    const ageCheckboxes = document.querySelectorAll<HTMLInputElement>('input[type="checkbox"]');
    const ageAllCheckbox = document.querySelector<HTMLInputElement>('input[type="checkbox"][value="all"]');
    ageCheckboxes.forEach((checkbox) => {
      checkbox.checked = false;
    });

    if (ageAllCheckbox) {
      ageAllCheckbox.checked = true;
    }
    this.allFilters();
  }
}

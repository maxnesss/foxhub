import { Component, Input, EventEmitter, Output } from '@angular/core';
import { Language } from "../../models/language";

@Component({
  selector: 'app-language-button',
  templateUrl: './language-button.component.html',
  styleUrls: ['./language-button.component.css']
})

export class LanguageButtonComponent {
  // @ts-ignore
  @Input() language: Language;
  @Input() userLanguages: Language[] | undefined;
  @Input() unusedLanguages: Language[] | undefined;
  @Output() languageComponentEmitter = new EventEmitter<Language[]>();

  sendLanguagesUp() {
    this.languageComponentEmitter.emit(this.userLanguages);
  }
  
  switchLanguage() {
    if (this.userLanguages?.some(userLanguage =>
      userLanguage.name === this.language.name)) {
      this.switchLanguageFromUserToUnused();
    } else {
      this.switchLanguageFromUnusedToUser();
    }
    this.sendLanguagesUp();
  }

  switchLanguageFromUnusedToUser() {
    // @ts-ignore
    for (const language of this.unusedLanguages) {
      if (language.name === this.language.name) {
        this.userLanguages?.push(language);
        // @ts-ignore
        const index = this.unusedLanguages.indexOf(language);
        if (index !== -1) {
          // @ts-ignore
          this.unusedLanguages.splice(index, 1);
        }
        break;
      }
    }
  }

  switchLanguageFromUserToUnused() {
    //@ts-ignore
    for (const language of this.userLanguages) {
      if (language.name === this.language.name) {
        this.unusedLanguages?.push(language);
        // @ts-ignore
        const index = this.userLanguages.indexOf(language);
        if (index !== -1) {
          // @ts-ignore
          this.userLanguages.splice(index, 1);
        }
        break;
      }
    }
  }
}

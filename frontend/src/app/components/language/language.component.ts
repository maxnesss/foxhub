import { Component, Input } from '@angular/core';
import { Language } from "../../models/language";

@Component({
  selector: 'app-language',
  templateUrl: './language.component.html',
  styleUrls: ['./language.component.css']
})

export class LanguageComponent {
  // @ts-ignore
  @Input() language: Language;
}

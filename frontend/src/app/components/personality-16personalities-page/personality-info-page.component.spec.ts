import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonalityInfoPageComponent } from './personality-info-page.component';

describe('PersonalityInfoPageComponent', () => {
  let component: PersonalityInfoPageComponent;
  let fixture: ComponentFixture<PersonalityInfoPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersonalityInfoPageComponent]
    });
    fixture = TestBed.createComponent(PersonalityInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

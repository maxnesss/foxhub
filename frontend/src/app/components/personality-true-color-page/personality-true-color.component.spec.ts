import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonalityTrueColorComponent } from './personality-true-color.component';

describe('PersonalityTrueColorComponent', () => {
  let component: PersonalityTrueColorComponent;
  let fixture: ComponentFixture<PersonalityTrueColorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PersonalityTrueColorComponent]
    });
    fixture = TestBed.createComponent(PersonalityTrueColorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

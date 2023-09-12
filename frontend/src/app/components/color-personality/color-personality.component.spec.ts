import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColorPersonalityComponent } from './color-personality.component';

describe('ColorPersonalityComponent', () => {
  let component: ColorPersonalityComponent;
  let fixture: ComponentFixture<ColorPersonalityComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ColorPersonalityComponent]
    });
    fixture = TestBed.createComponent(ColorPersonalityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpiritAnimalPageComponent } from './spirit-animal-page.component';

describe('SpiritAnimalPageComponent', () => {
  let component: SpiritAnimalPageComponent;
  let fixture: ComponentFixture<SpiritAnimalPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SpiritAnimalPageComponent]
    });
    fixture = TestBed.createComponent(SpiritAnimalPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

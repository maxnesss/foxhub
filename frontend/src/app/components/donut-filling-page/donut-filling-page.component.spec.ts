import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonutFillingPageComponent } from './donut-filling-page.component';

describe('DonutFillingPageComponent', () => {
  let component: DonutFillingPageComponent;
  let fixture: ComponentFixture<DonutFillingPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DonutFillingPageComponent]
    });
    fixture = TestBed.createComponent(DonutFillingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

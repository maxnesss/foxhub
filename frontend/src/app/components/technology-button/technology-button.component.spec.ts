import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TechnologyButtonComponent } from './technology-button.component';

describe('TechnologyButtonComponent', () => {
  let component: TechnologyButtonComponent;
  let fixture: ComponentFixture<TechnologyButtonComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TechnologyButtonComponent]
    });
    fixture = TestBed.createComponent(TechnologyButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

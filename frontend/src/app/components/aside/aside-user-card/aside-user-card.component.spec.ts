import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsideUserCardComponent } from './aside-user-card.component';

describe('AsideUserCardComponent', () => {
  let component: AsideUserCardComponent;
  let fixture: ComponentFixture<AsideUserCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AsideUserCardComponent]
    });
    fixture = TestBed.createComponent(AsideUserCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

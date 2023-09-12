import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PeoplePageCardComponent } from './people-page-card.component';

describe('PeoplePageCardComponent', () => {
  let component: PeoplePageCardComponent;
  let fixture: ComponentFixture<PeoplePageCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PeoplePageCardComponent]
    });
    fixture = TestBed.createComponent(PeoplePageCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

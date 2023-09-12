import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PeoplePageSearchbarComponent } from './people-page-searchbar.component';

describe('PeoplePageSearchbarComponent', () => {
  let component: PeoplePageSearchbarComponent;
  let fixture: ComponentFixture<PeoplePageSearchbarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PeoplePageSearchbarComponent]
    });
    fixture = TestBed.createComponent(PeoplePageSearchbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

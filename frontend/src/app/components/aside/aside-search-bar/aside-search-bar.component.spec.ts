import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsideSearchBarComponent } from './aside-search-bar.component';

describe('AsideSearchBarComponent', () => {
  let component: AsideSearchBarComponent;
  let fixture: ComponentFixture<AsideSearchBarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AsideSearchBarComponent]
    });
    fixture = TestBed.createComponent(AsideSearchBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

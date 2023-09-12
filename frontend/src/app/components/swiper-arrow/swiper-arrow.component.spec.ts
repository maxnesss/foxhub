import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SwiperArrowComponent } from './swiper-arrow.component';

describe('SwiperArrowComponent', () => {
  let component: SwiperArrowComponent;
  let fixture: ComponentFixture<SwiperArrowComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SwiperArrowComponent]
    });
    fixture = TestBed.createComponent(SwiperArrowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

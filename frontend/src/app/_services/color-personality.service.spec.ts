import { TestBed } from '@angular/core/testing';

import { ColorPersonalityService } from './color-personality.service';

describe('ColorPersonalityService', () => {
  let service: ColorPersonalityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ColorPersonalityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

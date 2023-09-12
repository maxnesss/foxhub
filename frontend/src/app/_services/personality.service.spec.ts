import { TestBed } from '@angular/core/testing';

import { PersonalityService } from './personality.service';

describe('PersonalityService', () => {
  let service: PersonalityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PersonalityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

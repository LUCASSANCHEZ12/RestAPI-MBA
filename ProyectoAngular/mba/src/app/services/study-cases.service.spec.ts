import { TestBed } from '@angular/core/testing';

import { StudyCasesService } from './study-cases.service';

describe('StudyCasesService', () => {
  let service: StudyCasesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudyCasesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

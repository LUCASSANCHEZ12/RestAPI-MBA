import { TestBed } from '@angular/core/testing';

import { TeacherCasesService } from './teacher-cases.service';

describe('TeacherCasesService', () => {
  let service: TeacherCasesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TeacherCasesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

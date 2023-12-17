import { TestBed } from '@angular/core/testing';

import { TeacherSolutionService } from './teacher-solution.service';

describe('TeacherSolutionService', () => {
  let service: TeacherSolutionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TeacherSolutionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

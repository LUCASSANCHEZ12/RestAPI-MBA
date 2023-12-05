import { TestBed } from '@angular/core/testing';

import { AdminProgramasService } from './admin-programas.service';

describe('AdminProgramasService', () => {
  let service: AdminProgramasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminProgramasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

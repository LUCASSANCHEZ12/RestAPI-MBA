import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MateriasDocenteComponent } from './materias-docente.component';

describe('MateriasDocenteComponent', () => {
  let component: MateriasDocenteComponent;
  let fixture: ComponentFixture<MateriasDocenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MateriasDocenteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MateriasDocenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

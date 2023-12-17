import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MateriasEstudianteComponent } from './materias-estudiante.component';

describe('MateriasEstudianteComponent', () => {
  let component: MateriasEstudianteComponent;
  let fixture: ComponentFixture<MateriasEstudianteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MateriasEstudianteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MateriasEstudianteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

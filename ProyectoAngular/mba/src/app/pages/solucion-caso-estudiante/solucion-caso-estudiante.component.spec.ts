import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SolucionCasoEstudianteComponent } from './solucion-caso-estudiante.component';

describe('SolucionCasoEstudianteComponent', () => {
  let component: SolucionCasoEstudianteComponent;
  let fixture: ComponentFixture<SolucionCasoEstudianteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SolucionCasoEstudianteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SolucionCasoEstudianteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

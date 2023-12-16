import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SolucionCasoDocenteComponent } from './solucion-caso-docente.component';

describe('SolucionCasoDocenteComponent', () => {
  let component: SolucionCasoDocenteComponent;
  let fixture: ComponentFixture<SolucionCasoDocenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SolucionCasoDocenteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SolucionCasoDocenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

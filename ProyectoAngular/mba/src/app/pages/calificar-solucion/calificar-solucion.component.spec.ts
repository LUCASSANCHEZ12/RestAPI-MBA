import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalificarSolucionComponent } from './calificar-solucion.component';

describe('CalificarSolucionComponent', () => {
  let component: CalificarSolucionComponent;
  let fixture: ComponentFixture<CalificarSolucionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CalificarSolucionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CalificarSolucionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

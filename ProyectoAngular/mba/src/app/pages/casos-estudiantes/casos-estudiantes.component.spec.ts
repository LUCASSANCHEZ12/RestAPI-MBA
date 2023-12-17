import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CasosEstudiantesComponent } from './casos-estudiantes.component';

describe('CasosEstudiantesComponent', () => {
  let component: CasosEstudiantesComponent;
  let fixture: ComponentFixture<CasosEstudiantesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CasosEstudiantesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CasosEstudiantesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

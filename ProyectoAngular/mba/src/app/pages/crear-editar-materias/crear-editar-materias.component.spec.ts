import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearEditarMateriasComponent } from './crear-editar-materias.component';

describe('CrearEditarMateriasComponent', () => {
  let component: CrearEditarMateriasComponent;
  let fixture: ComponentFixture<CrearEditarMateriasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CrearEditarMateriasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CrearEditarMateriasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

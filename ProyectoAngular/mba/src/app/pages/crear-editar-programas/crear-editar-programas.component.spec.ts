import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearEditarProgramasComponent } from './crear-editar-programas.component';

describe('CrearEditarProgramasComponent', () => {
  let component: CrearEditarProgramasComponent;
  let fixture: ComponentFixture<CrearEditarProgramasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CrearEditarProgramasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CrearEditarProgramasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

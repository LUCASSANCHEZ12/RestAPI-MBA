import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearCasosEstudioComponent } from './crear-casos-estudio.component';

describe('CrearCasosEstudioComponent', () => {
  let component: CrearCasosEstudioComponent;
  let fixture: ComponentFixture<CrearCasosEstudioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CrearCasosEstudioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CrearCasosEstudioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

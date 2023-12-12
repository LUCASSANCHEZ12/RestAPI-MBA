import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerCasosEstudioComponent } from './ver-casos-estudio.component';

describe('VerCasosEstudioComponent', () => {
  let component: VerCasosEstudioComponent;
  let fixture: ComponentFixture<VerCasosEstudioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [VerCasosEstudioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerCasosEstudioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

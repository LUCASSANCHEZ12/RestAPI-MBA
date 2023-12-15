import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CasosDocentesComponent } from './casos-docentes.component';

describe('CasosDocentesComponent', () => {
  let component: CasosDocentesComponent;
  let fixture: ComponentFixture<CasosDocentesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CasosDocentesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CasosDocentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

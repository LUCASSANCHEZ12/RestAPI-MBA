import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAddStudyCaseComponent } from './user-add-study-case.component';

describe('UserAddStudyCaseComponent', () => {
  let component: UserAddStudyCaseComponent;
  let fixture: ComponentFixture<UserAddStudyCaseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserAddStudyCaseComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UserAddStudyCaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

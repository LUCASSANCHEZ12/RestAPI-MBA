import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserStudyCaseComponent } from './user-study-case.component';

describe('UserStudyCaseComponent', () => {
  let component: UserStudyCaseComponent;
  let fixture: ComponentFixture<UserStudyCaseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserStudyCaseComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UserStudyCaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayConsultantComponent } from './display-consultant.component';

describe('DisplayConsultantComponent', () => {
  let component: DisplayConsultantComponent;
  let fixture: ComponentFixture<DisplayConsultantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayConsultantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayConsultantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

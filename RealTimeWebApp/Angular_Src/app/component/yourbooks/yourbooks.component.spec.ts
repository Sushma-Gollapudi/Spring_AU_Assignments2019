import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YourbooksComponent } from './yourbooks.component';

describe('YourbooksComponent', () => {
  let component: YourbooksComponent;
  let fixture: ComponentFixture<YourbooksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YourbooksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YourbooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RenameImageDialogComponent } from './rename-image-dialog.component';

describe('RenameImageDialogComponent', () => {
  let component: RenameImageDialogComponent;
  let fixture: ComponentFixture<RenameImageDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RenameImageDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RenameImageDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

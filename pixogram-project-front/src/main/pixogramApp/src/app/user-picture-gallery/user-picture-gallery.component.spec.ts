import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPictureGalleryComponent } from './user-picture-gallery.component';

describe('UserPictureGalleryComponent', () => {
  let component: UserPictureGalleryComponent;
  let fixture: ComponentFixture<UserPictureGalleryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserPictureGalleryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserPictureGalleryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

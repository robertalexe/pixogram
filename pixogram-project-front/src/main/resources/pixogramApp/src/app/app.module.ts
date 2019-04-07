import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HttpClient, HttpHandler, HttpClientModule } from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {JwtInterceptor} from "./_helper/jwt.interceptor";
import {ErrorInterceptor} from "./_helper/error.interceptor";
import {CustomMaterialModule} from "./_helper/custom.material";
import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import { ForbiddenComponent } from './forbidden/forbidden.component';
import {MatListModule, MatSidenavModule, MatSnackBarModule, MatTooltipModule} from "@angular/material";
import { ToolbarComponent } from './navigation/toolbar/toolbar.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {HomepageComponent, SnackbarPictureDisliked, SnackbarPictureLiked} from './homepage/homepage.component';
import { SidebarComponent } from './navigation/sidebar/sidebar.component';
import { UploadPictureComponent } from './upload-picture/upload-picture.component';
import {UploadPictureService} from "./_services/upload-picture.service";
import {
  SnackbarPictureDeleted,
  SnackbarPictureHidden, SnackbarPictureUnHidden,
  UserPictureGalleryComponent
} from './user-picture-gallery/user-picture-gallery.component';
import { PictureDialogComponent } from './picture-dialog/picture-dialog.component';
import {
  SnackbarSubscribed,
  SnackbarUnSubscribed,
  SubscribeListComponent
} from './subscribe-list/subscribe-list.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ImgWrapperComponent } from './img-wrapper/img-wrapper.component';
import { RenameImageDialogComponent } from './rename-image-dialog/rename-image-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ForbiddenComponent,
    ToolbarComponent,
    HomepageComponent,
    SidebarComponent,
    UploadPictureComponent,
    UserPictureGalleryComponent,
    PictureDialogComponent,
    SubscribeListComponent,
    ProfilePageComponent,
    ImgWrapperComponent,
    RenameImageDialogComponent,
    SnackbarSubscribed,
    SnackbarUnSubscribed,
    SnackbarPictureHidden,
    SnackbarPictureUnHidden,
    SnackbarPictureDeleted,
    SnackbarPictureLiked,
    SnackbarPictureDisliked
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    CustomMaterialModule,
    FormsModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatListModule,
    MatSidenavModule,
    FlexLayoutModule,
    MatSnackBarModule,
    MatTooltipModule
  ],
  providers: [
    HttpClient,
    UploadPictureService,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  exports: [
    MatListModule,
    MatSidenavModule
  ],
  entryComponents: [
    PictureDialogComponent,
    RenameImageDialogComponent,
    SnackbarSubscribed,
    SnackbarUnSubscribed,
    SnackbarPictureHidden,
    SnackbarPictureUnHidden,
    SnackbarPictureDeleted,
    SnackbarPictureLiked,
    SnackbarPictureDisliked
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

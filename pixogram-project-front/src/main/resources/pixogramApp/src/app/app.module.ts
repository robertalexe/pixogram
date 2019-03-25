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
import { ProfilePictureComponent } from './profile-picture/profile-picture.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import {MatListModule, MatSidenavModule} from "@angular/material";
import { ToolbarComponent } from './navigation/toolbar/toolbar.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import { HomepageComponent } from './homepage/homepage.component';
import { SidebarComponent } from './navigation/sidebar/sidebar.component';
import { UploadPictureComponent } from './upload-picture/upload-picture.component';
import {UploadPictureService} from "./_services/upload-picture.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProfilePictureComponent,
    ForbiddenComponent,
    ToolbarComponent,
    HomepageComponent,
    SidebarComponent,
    UploadPictureComponent
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
    FlexLayoutModule
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
  bootstrap: [AppComponent]
})
export class AppModule { }

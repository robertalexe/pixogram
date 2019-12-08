import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./_guards/auth.guard";
import {ForbiddenComponent} from "./forbidden/forbidden.component";
import {HomepageComponent} from "./homepage/homepage.component";
import {UploadPictureComponent} from "./upload-picture/upload-picture.component";
import {UserPictureGalleryComponent} from "./user-picture-gallery/user-picture-gallery.component";
import {SubscribeListComponent} from "./subscribe-list/subscribe-list.component";
import {ProfilePageComponent} from "./profile-page/profile-page.component";

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
    canActivate: []
  },
  {
    path: 'homepage',
    component: HomepageComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'forbidden',
    component: ForbiddenComponent,
    canActivate: []
  },
  {
    path: 'upload-picture',
    component: UploadPictureComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'picture-gallery',
    component: UserPictureGalleryComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'subscribers-list',
    component: SubscribeListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'profile',
    component: ProfilePageComponent,
    canActivate: [AuthGuard]
  },
  {
    path: '**', redirectTo: 'homepage'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

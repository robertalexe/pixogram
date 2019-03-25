import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./_guards/auth.guard";
import {ForbiddenComponent} from "./forbidden/forbidden.component";
import {HomepageComponent} from "./homepage/homepage.component";

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
    path: '**', redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component } from '@angular/core';
import {AuthenticationService} from "./_services/authentication.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'pixogramApp';

  private authenticatedUser:boolean = false;

  constructor(private authService:AuthenticationService) {
    this.authService.currentUserSubject.subscribe((data) => {
      if (data.username) {
        this.authenticatedUser = true;
      }
      ;
    })
  }
}

import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AuthenticationService} from "../../_services/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {

  private authenticatedUser:boolean = false;
  @Output() toggleSidenav = new EventEmitter<void>();

  @Input()
  private loggedInUser:boolean;

  constructor(private authService:AuthenticationService,
              private routes:Router) {
    this.authService.currentUserSubject.subscribe((data) => {
        if (data.username) {
          this.authenticatedUser = true;
        }
        ;
      }
    )
  }

  ngOnInit() {

  }

  private logout() {
    this.authService.logout();
    this.routes.navigate(['login']);
    location.reload();
  }

}

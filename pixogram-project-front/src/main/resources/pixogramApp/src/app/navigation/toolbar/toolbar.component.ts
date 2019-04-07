import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AuthenticationService} from "../../_services/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {

  @Output() toggleSidenav = new EventEmitter<void>();

  public username: string;

  constructor(private authService:AuthenticationService,
              private routes:Router) {
    this.username = authService.currentUserSubject.getValue() ? authService.currentUserSubject.getValue().username : null;
  }

  ngOnInit() {

  }

  private logout() {
    this.authService.logout();
    this.routes.navigate(['login']);
    location.reload();
  }

}

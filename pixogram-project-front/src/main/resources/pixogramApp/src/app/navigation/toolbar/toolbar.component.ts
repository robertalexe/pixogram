import {Component, EventEmitter, OnInit, Output} from '@angular/core';
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

  constructor(private authService:AuthenticationService,
              private routes:Router) { }

  ngOnInit() {
    this.authService.currentUserValue ? this.authenticatedUser = true : this.authenticatedUser = false;
  }

  private logout() {
    this.authService.logout();
    this.routes.navigate(['login']);
    location.reload();
  }

}

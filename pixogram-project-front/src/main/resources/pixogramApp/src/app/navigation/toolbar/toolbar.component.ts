import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AuthenticationService} from "../../_services/authentication.service";
import {Router} from "@angular/router";
import {ProfilePictureService} from "../../_services/profile-picture.service";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {

  @Output() toggleSidenav = new EventEmitter<void>();

  constructor(private authService:AuthenticationService,
              private routes:Router) {
  }

  ngOnInit() {

  }

  private logout() {
    this.authService.logout();
    this.routes.navigate(['login']);
    location.reload();
  }

}

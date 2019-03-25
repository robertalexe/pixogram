import { Component } from '@angular/core';
import {AuthenticationService} from "./_services/authentication.service";
import {User} from "./_models/user";
import {HttpClient} from "@angular/common/http";
import {SingleValue} from "./_models/single-value";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'pixogramApp';

  constructor() { }

}

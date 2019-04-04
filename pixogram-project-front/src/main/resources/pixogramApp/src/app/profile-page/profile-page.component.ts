import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserProfile} from "../_models/user-profile";

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  private userProfile: UserProfile = new UserProfile();

  constructor(private http:HttpClient) {
    this.http.get<UserProfile>('http://localhost:8080/api/user-details').subscribe( resp => {
      this.userProfile = resp;
    });
  }

  ngOnInit() {
  }

  getUserProfilePictureUrl() {
    return 'http://localhost:8080/api/profile-picture';
  }

}

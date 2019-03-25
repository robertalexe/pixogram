import { Component, OnInit } from '@angular/core';
import {ProfilePictureService} from "../_services/profile-picture.service";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-profile-picture',
  template: `
    <img [src]="image" class="profile-pic"/>
  `,
  styleUrls: ['./profile-picture.component.css']
})
export class ProfilePictureComponent implements OnInit{

  image:SafeResourceUrl;

  constructor(private service:ProfilePictureService, private _sanitizer: DomSanitizer) {}

  ngOnInit(): void {
    this.showImage();
  }

  showImage() {
    this.service.getImage()
      .subscribe((file) => {
        console.log('received inage is');
        console.log(file);
        this.image = this._sanitizer.bypassSecurityTrustResourceUrl(file.value);
      });
  }

}



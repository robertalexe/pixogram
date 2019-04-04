import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material";
import {PictureDialogComponent} from "../picture-dialog/picture-dialog.component";
import {HttpClient} from "@angular/common/http";
import {PictureMetadata} from "../_models/picture-metadata";

@Component({
  selector: 'app-user-picture-gallery',
  templateUrl: './user-picture-gallery.component.html',
  styleUrls: ['./user-picture-gallery.component.css']
})
export class UserPictureGalleryComponent implements OnInit {

  constructor(public dialog: MatDialog, public http: HttpClient) {
    http.get<Array<string>>('http://localhost:8080/api/my-gallery').subscribe( resp => {
      for(let index in resp) {
        this.http.get<PictureMetadata>('http://localhost:8080/api/download-image-metadata/' + resp[index]).subscribe( response => {
          this.pictures.push(
            {
              id: resp[index],
              title: response.name,
              img: 'http://localhost:8080/api/download-image/' + resp[index],
              likedBy: response.likedBy
            }
          )
        })
      }
    });

  }

  ngOnInit() {
  }

  pictures = [];

  display(pic:string, id:string):any
  {
    let dialogRef = this.dialog.open(PictureDialogComponent, {
      data: {
        pic: pic,
        id: id
      }
    });
  }

}

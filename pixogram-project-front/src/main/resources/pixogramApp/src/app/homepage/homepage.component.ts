import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material";
import {PictureDialogComponent} from "../picture-dialog/picture-dialog.component";
import {HttpClient} from "@angular/common/http";
import {PictureMetadata} from "../_models/picture-metadata";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(public dialog: MatDialog, public http: HttpClient) {
    http.get<Array<string>>('http://localhost:8080/api/newsfeed').subscribe( resp => {
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

  likePicture(id:string) {
    this.http.post('http://localhost:8080/api/like/' + id, null).subscribe( resp => console.log(resp));
    for(let index in this.pictures) {
      if(this.pictures[index].id == id) {
        this.http.get<PictureMetadata>('http://localhost:8080/api/download-image-metadata/' + id).subscribe( response => {
          this.pictures[index] = {
            id: this.pictures[index].id,
            title: response.name,
            img: 'http://localhost:8080/api/download-image/' + this.pictures[index].id,
            likedBy: response.likedBy
          }
        });
      }
    }
  }

  dislikePicture(id:string) {
    this.http.post('http://localhost:8080/api/dislike/' + id, null).subscribe( resp => console.log(resp));
    for(let index in this.pictures) {
      if(this.pictures[index].id == id) {
        this.http.get<PictureMetadata>('http://localhost:8080/api/download-image-metadata/' + id).subscribe( response => {
          this.pictures[index] = {
            id: this.pictures[index].id,
            title: response.name,
            img: 'http://localhost:8080/api/download-image/' + this.pictures[index].id,
            likedBy: response.likedBy
          }
        });
      }
    }
  }

  refreshPictures

}

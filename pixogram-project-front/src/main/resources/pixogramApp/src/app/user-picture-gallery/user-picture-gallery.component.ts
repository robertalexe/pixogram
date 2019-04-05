import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material";
import {PictureDialogComponent} from "../picture-dialog/picture-dialog.component";
import {HttpClient} from "@angular/common/http";
import {PictureMetadata} from "../_models/picture-metadata";
import {RenameImageDialogComponent} from "../rename-image-dialog/rename-image-dialog.component";
import {RequestOptions} from "@angular/http";
import {saveAs} from "file-saver";

@Component({
  selector: 'app-user-picture-gallery',
  templateUrl: './user-picture-gallery.component.html',
  styleUrls: ['./user-picture-gallery.component.css']
})
export class UserPictureGalleryComponent implements OnInit {

  constructor(public dialog: MatDialog, public http: HttpClient) {
    this.getPicturesData();

  }

  private getPicturesData() {
    this.pictures = [];
    this.http.get<Array<string>>('http://localhost:8080/api/my-gallery').subscribe(resp => {
      for (let index in resp) {
        this.http.get<PictureMetadata>('http://localhost:8080/api/download-image-metadata/' + resp[index]).subscribe(response => {
          this.pictures.push(
            {
              id: resp[index],
              title: response.name,
              img: 'http://localhost:8080/api/download-image/' + resp[index],
              likedBy: response.likedBy,
              visible: response.visibleToFollowers
            }
          );
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

  changeName(pictureId):any
  {
    let dialogRef = this.dialog.open(RenameImageDialogComponent, {
      data: pictureId
    });
    dialogRef.afterClosed().subscribe( resp => {
      for(let index in this.pictures) {
        if(this.pictures[index].id == pictureId) {
          this.http.get<PictureMetadata>('http://localhost:8080/api/download-image-metadata/' + pictureId).subscribe( response => {
            this.pictures[index] = {
              id: this.pictures[index].id,
              title: response.name,
              img: 'http://localhost:8080/api/download-image/' + this.pictures[index].id,
              likedBy: response.likedBy,
              visible: response.visibleToFollowers
            }
          });
        }
      }
    })
  }

  delete(pictureId):any {
    this.http.post('http://localhost:8080/api/delete-image/' + pictureId, null).subscribe( resp => {this.getPicturesData();});

  }
  download(pictureId, pictureName):any {
    this.http.get('http://localhost:8080/api/download-image/' + pictureId, {responseType:'blob'}).subscribe( data => {
      saveAs(data, pictureName);
    });
  }
  hide(pictureId) {
    this.http.post('http://localhost:8080/api/image-visibility/hide/' + pictureId, null).subscribe( resp => {this.getPicturesData()});

  }

  unhide(pictureId) {
    this.http.post('http://localhost:8080/api/image-visibility/unhide/' + pictureId, null).subscribe( resp => {this.getPicturesData()});
  }

}

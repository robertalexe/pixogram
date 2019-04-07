import { Component, OnInit } from '@angular/core';
import {MatDialog, MatDialogConfig, MatSnackBar} from "@angular/material";
import {PictureDialogComponent} from "../picture-dialog/picture-dialog.component";
import {HttpClient} from "@angular/common/http";
import {PictureMetadata} from "../_models/picture-metadata";

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  constructor(public dialog: MatDialog, public http: HttpClient, private snackbar: MatSnackBar) {
    http.get<Array<string>>('/api/newsfeed').subscribe( resp => {
      for(let index in resp) {
        this.http.get<PictureMetadata>('/api/download-image-metadata/' + resp[index]).subscribe( response => {
          this.pictures.push(
            {
              id: resp[index],
              title: response.name,
              img: '/api/download-image/' + resp[index],
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

  parentStyle='img-wrap';

  display(pic:string, id:string, picName:string):any
  {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    let dialogRef = this.dialog.open(PictureDialogComponent, {
      data: {
        pic: pic,
        id: id,
        picName: picName
      }
    });
  }

  likePicture(id:string) {
    this.http.post('/api/like/' + id, null).subscribe(resp => {
      for (let index in this.pictures) {
        if (this.pictures[index].id == id) {
          this.http.get<PictureMetadata>('/api/download-image-metadata/' + id).subscribe(response => {
            this.pictures[index] = {
              id: this.pictures[index].id,
              title: response.name,
              img: '/api/download-image/' + this.pictures[index].id,
              likedBy: response.likedBy
            };
            this.snackbar.openFromComponent(SnackbarPictureLiked, {
              duration: 3000,
            });
          });
        }
      }
    });
  }

  dislikePicture(id:string) {
    this.http.post('/api/dislike/' + id, null).subscribe(resp => {
      for (let index in this.pictures) {
        if (this.pictures[index].id == id) {
          this.http.get<PictureMetadata>('/api/download-image-metadata/' + id).subscribe(response => {
            this.pictures[index] = {
              id: this.pictures[index].id,
              title: response.name,
              img: '/api/download-image/' + this.pictures[index].id,
              likedBy: response.likedBy
            };
            this.snackbar.openFromComponent(SnackbarPictureDisliked, {
              duration: 3000,
            });
          });
        }
      }
    });
  }

}

@Component({
  selector: 'snackbar-like',
  template: '<span class="snackbar-proposal">\n' +
    '  You liked the picture!\n' +
    '</span>',
  styles: [`
    .snackbar-proposal {
      color: #673ab7;
    }
  `],
})
export class SnackbarPictureLiked {}

@Component({
  selector: 'snackbar-dislike',
  template: '<span class="snackbar-proposal">\n' +
    '  You disliked the picture!!\n' +
    '</span>',
  styles: [`
    .snackbar-proposal {
      color: #673ab7;
    }
  `],
})
export class SnackbarPictureDisliked {}

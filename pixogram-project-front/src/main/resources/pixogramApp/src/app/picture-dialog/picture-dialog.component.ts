import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {Comment} from "../_models/comment";
import {HttpClient} from "@angular/common/http";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-picture-dialog',
  templateUrl: './picture-dialog.component.html',
  styleUrls: ['./picture-dialog.component.css']
})
export class PictureDialogComponent implements OnInit {

  comments = [
  ];

  myForm: FormGroup;

  constructor(public thisDialogRef: MatDialogRef<PictureDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: any,
              private http: HttpClient, fb: FormBuilder) {
    this.myForm = fb.group({
      'newComment': ['', Validators.required]
    });

    this.http.get<Comment[]>('http://localhost:8080/api/comment/' + data.id).subscribe( resp => {
      for(let index in resp) {
        this.comments.push(
          new Comment(
            resp[index].id,
            resp[index].comment,
            'panel panel-success'

          )
        )
      }
    });
  }

  ngOnInit() {
  }

  addComment(formValues) {
    this.http.post('http://localhost:8080/api/comment/' + this.data.id, {comment: formValues.newComment}).subscribe( resp => {
      this.comments = [];
      this.http.get<Comment[]>('http://localhost:8080/api/comment/' + this.data.id).subscribe( resp => {
        for(let index in resp) {
          this.comments.push(
            new Comment(
              resp[index].id,
              resp[index].comment,
              'panel panel-success'

            )
          )
        }
      });
    });

  }
}

import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-rename-image-dialog',
  templateUrl: './rename-image-dialog.component.html',
  styleUrls: ['./rename-image-dialog.component.css']
})
export class RenameImageDialogComponent implements OnInit {

  myForm: FormGroup;

  constructor(fb: FormBuilder, private http: HttpClient,  @Inject(MAT_DIALOG_DATA) public data: string,
              public dialogRef: MatDialogRef<RenameImageDialogComponent>) {
    this.myForm = fb.group({
      'newImageName': ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  renameImage(formValues) {
    this.http.post('/api/rename?pictureName=' + formValues.newImageName + '&pictureId=' + this.data, null).subscribe( rsp => {
      this.dialogRef.close();
    });
  }

}

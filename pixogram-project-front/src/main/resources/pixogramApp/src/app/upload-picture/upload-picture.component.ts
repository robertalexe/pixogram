import { Component, OnInit } from '@angular/core';
import {UploadPictureService} from "../_services/upload-picture.service";
import {HttpEventType, HttpResponse} from "@angular/common/http";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-upload-picture',
  templateUrl: './upload-picture.component.html',
  styleUrls: ['./upload-picture.component.css']
})
export class UploadPictureComponent implements OnInit {

  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };

  myForm: FormGroup;

  constructor(private uploadService: UploadPictureService, fb: FormBuilder) {
    this.myForm = fb.group({
        'inputPictureName': ['', Validators.required],
        'inputPictureComment': ['', Validators.required],
        'inputFile': ['', Validators.required],
        'inputPictureToggle': ['', Validators.required]
      }
    );
  }

  ngOnInit() {
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload(formValues) {
    this.progress.percentage = 0;

    this.currentFileUpload = this.selectedFiles.item(0);
    this.uploadService.pushFileToStorage(this.currentFileUpload, formValues.inputPictureName, formValues.inputPictureComment, formValues.inputPictureToggle).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    });

    this.selectedFiles = undefined
  }

}

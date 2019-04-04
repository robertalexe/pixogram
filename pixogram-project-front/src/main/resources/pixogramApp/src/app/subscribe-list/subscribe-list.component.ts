import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Subscriber} from "../_models/subsciber";
import {MatSlideToggleChange} from "@angular/material";

@Component({
  selector: 'app-subscribe-list',
  templateUrl: './subscribe-list.component.html',
  styleUrls: ['./subscribe-list.component.css']
})
export class SubscribeListComponent implements OnInit {

  displayedColumns: string[] = ['email', 'toggle'];
  dataSource ;

  constructor(private http: HttpClient) {
    http.get<Subscriber[]>('http://localhost:8080/api/subscribers/all').subscribe( resp => {
      this.dataSource = resp;
    });
  }

  ngOnInit() {
  }

  toggle(event: MatSlideToggleChange, email: string) {
    if(event.checked) {
      this.http.post('http://localhost:8080/api/subscribers/add/' + email, null).subscribe();
    } else {
      this.http.post('http://localhost:8080/api/subscribers/remove/' + email, null).subscribe();
    }
  }

}

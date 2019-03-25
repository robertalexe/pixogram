import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {SingleValue} from "../_models/single-value";

@Injectable({ providedIn: 'root' })
export class ProfilePictureService {

  constructor(private http:HttpClient) {}

  getImage() {
    return this.http.get<SingleValue>('http://localhost:8080/api/random-image/');
  }
}

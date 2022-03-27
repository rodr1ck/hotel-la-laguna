import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PasajerosService {

  urlPassenger = 'http://localhost:8080/pasajero';

  constructor(private http:HttpClient) { }

  getPasajero():Observable<any>{
    return this.http.get(this.urlPassenger);
  }

}

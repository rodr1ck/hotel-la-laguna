import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PasajerosService {
  urlPassenger = 'http://localhost:8080/pasajero';

  constructor(private http: HttpClient) {}

  getPasajero(): Observable<any> {
    return this.http.get(this.urlPassenger);
  }

  sendPasajero(passenger: any) {
    return this.http.post(this.urlPassenger, passenger);
  }

  deletePasajero(id: any) {
    return this.http.delete(`${this.urlPassenger}/${id}`);
  }

  getOnePassanger(id: any) {
    return this.http.get(`${this.urlPassenger}/${id}`);
  }

}

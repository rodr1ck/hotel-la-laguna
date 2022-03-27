import { Component, OnInit } from '@angular/core';
import { PasajerosService } from '../../../services/pasajeros.service';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css'],
})
export class ListadoComponent implements OnInit {
  pasajero: any;

  constructor(private passengerService: PasajerosService) {}

  ngOnInit(): void {
    this.getPasajero();
  }

  getPasajero() {
    this.passengerService.getPasajero().subscribe((resp) => {
      console.log('resp pasajero', resp);
      this.pasajero = resp;
    });
  }
}

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

  buttonStyle = {
    display: 'flex',
    'flex-direction': 'row',
    'justify-content': 'flex-end',
    'margin-right': '20px',
    'margin-bottom': '30px',
  };

  ngOnInit(): void {
    this.getPasajero();
  }

  getPasajero() {
    this.passengerService.getPasajero().subscribe((resp) => {
      this.pasajero = resp;
    });
  }

  delete(id: any): void {
    console.log('deletePasajero ', id);
    this.passengerService.deletePasajero(id).subscribe();
    window.alert('Pasajero borrado');
    window.location.href = '/';
  }
}

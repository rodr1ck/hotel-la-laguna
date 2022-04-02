import { Component, OnInit } from '@angular/core';
import { PasajerosService } from '../../../services/pasajeros.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar',
  templateUrl: './editar.component.html',
  styleUrls: ['./editar.component.css'],
})
export class EditarComponent implements OnInit {
  forma: FormGroup;
  id: any;
  pasajero: any;

  constructor(
    private fb: FormBuilder,
    private pasajeroService: PasajerosService,
    private router: ActivatedRoute,
    private _route: Router
  ) {
    this.forma = this.fb.group({
      pasajero_nombre: ['', [Validators.required, Validators.minLength(3)]],
      nacionalidad: ['', [Validators.required, Validators.minLength(3)]],
      numero_habitacion: ['', [Validators.required, Validators.minLength(3)]],
      fecha_ingreso: ['', [Validators.required]],
      fecha_salida: [''],
      tipo_paquete: ['', [Validators.required]],
    });
  }

  formStyle = {
    display: 'flex',
    'flex-direction': 'column',
    alignItems: 'center',
  };

  ngOnInit(): void {
    this.router.params.subscribe((paramsId) => {
      this.id = paramsId['id'];
    });
    this.pasajeroService.getOnePassanger(this.id).subscribe((resp) => {
      this.chargeForm(resp);
    });
  }

  guardar() {
    this.createPassenger();
  }

  createPassenger() {
    let obj = {
      pasajeroId: this.id,
      pasajero_nombre: this.forma.get('pasajero_nombre')?.value,
      nacionalidad: this.forma.get('nacionalidad')?.value,
      numero_habitacion: this.forma.get('numero_habitacion')?.value,
      fecha_ingreso: this.forma.get('fecha_ingreso')?.value,
      fecha_salida: this.forma.get('fecha_salida')?.value,
      tipo_paquete: this.forma.get('tipo_paquete')?.value,
    };
    this.pasajeroService.sendPasajero(obj).subscribe((respuesta) => {
      console.log(respuesta);
    });
    this._route.navigate(['/']);
  }

  chargeForm(data: any) {
    this.forma = this.fb.group({
      pasajero_nombre: [data.pasajero_nombre],
      nacionalidad: [data.nacionalidad],
      numero_habitacion: [data.numero_habitacion],
      fecha_ingreso: [data.fecha_ingreso],
      fecha_salida: [data.fecha_salida],
      tipo_paquete: [data.tipo_paquete],
    });
  }
}

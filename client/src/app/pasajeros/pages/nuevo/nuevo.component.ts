import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PasajerosService } from '../../../services/pasajeros.service';

@Component({
  selector: 'app-nuevo',
  templateUrl: './nuevo.component.html',
  styleUrls: ['./nuevo.component.css'],
})
export class NuevoComponent implements OnInit {
  forma: FormGroup;

  constructor(
    private fb: FormBuilder,
    private pasajeroService: PasajerosService,
    private router: Router
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

  ngOnInit(): void {}

  guardar() {
    this.createPassenger();
  }

  createPassenger() {
    let obj = {
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
    this.router.navigate(['/home']);
  }
}

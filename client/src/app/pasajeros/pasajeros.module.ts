import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PasajerosRoutingModule } from './pasajeros-routing.module';
import { NuevoComponent } from './pages/nuevo/nuevo.component';
import { EditarComponent } from './pages/editar/editar.component';
import { ListadoComponent } from './pages/listado/listado.component';


@NgModule({
  declarations: [
    NuevoComponent,
    EditarComponent,
    ListadoComponent
  ],
  imports: [
    CommonModule,
    PasajerosRoutingModule
  ]
})
export class PasajerosModule { }

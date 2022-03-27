import { LOCALE_ID, NgModule } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';

import { PasajerosRoutingModule } from './pasajeros-routing.module';
import { NuevoComponent } from './pages/nuevo/nuevo.component';
import { EditarComponent } from './pages/editar/editar.component';
import { ListadoComponent } from './pages/listado/listado.component';
import localeEsCL from '@angular/common/locales/es-CL';

registerLocaleData(localeEsCL);

@NgModule({
  declarations: [
    NuevoComponent,
    EditarComponent,
    ListadoComponent
  ],
  imports: [
    CommonModule,
    PasajerosRoutingModule
  ],
	providers: [{ provide: LOCALE_ID, useValue: 'es-CL' }],
})
export class PasajerosModule { }

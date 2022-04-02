import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditarComponent } from './pages/editar/editar.component';
import { ListadoComponent } from './pages/listado/listado.component';
import { NuevoComponent } from './pages/nuevo/nuevo.component';

const routes: Routes = [{ path: '', children: [
  { path: 'nuevo', component: NuevoComponent },
  { path: 'editar/:id', component: EditarComponent },
  { path: 'listado', component: ListadoComponent },
  { path: '**', redirectTo: 'listado' },
] }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PasajerosRoutingModule { }

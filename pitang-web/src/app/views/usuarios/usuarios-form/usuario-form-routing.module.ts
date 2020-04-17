import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UsuarioFormComponent } from './usuario-form.component';

const routes: Routes = [
	{
    path: '',
    component: UsuarioFormComponent,
    data: {
      title: 'Veículo'
    }
  },
  {
    path: ':id',
    component: UsuarioFormComponent,
    data: {
      title: 'Veículo'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuarioFormRoutingModule { }

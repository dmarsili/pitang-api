import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { VeiculoFormComponent } from './veiculos-form.component';

const routes: Routes = [
	{
    path: '',
    component: VeiculoFormComponent,
    data: {
      title: 'Veículo'
    }
  },
  {
    path: ':id',
    component: VeiculoFormComponent,
    data: {
      title: 'Veículo'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VeiculoFormRoutingModule { }

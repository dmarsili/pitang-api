import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VeiculosComponent } from './veiculos.component';

const routes: Routes = [
	{
    path: '',
    component: VeiculosComponent,
    data: {
      title: 'Veículos'
    }
  },
  {
    path: '',        
    data: {
      title: 'Veículos'
    },
    children: [                   
      {
        path: 'formulario',
        loadChildren: './veiculos-form/veiculos-form.module#VeiculoFormModule'
      }      
    ]
  } 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VeiculosRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UsuariosComponent } from './usuarios.component';

const routes: Routes = [
	{
    path: '',
    component: UsuariosComponent,
    data: {
      title: 'Usuários'
    }
  },
  {
    path: '',        
    data: {
      title: 'Usuários'
    },
    children: [                   
      {
        path: 'formulario',
        loadChildren: './usuarios-form/usuario-form.module#UsuarioFormModule'
      }      
    ]
  } 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsuariosRoutingModule { }

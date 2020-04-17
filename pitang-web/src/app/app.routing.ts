import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Import Containers
import {
  FullLayoutComponent,
  SimpleLayoutComponent
} from './containers';
import { LoginComponent } from './views/login/login.component';
import { AuthGuard } from './services/auth-guard.service';
import { CadastroComponent } from './views/cadastro/cadastro.component';
import { LogoutComponent } from './views/logout/logout.component';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'inicio'
  },
  {
    path: 'login',
    component: LoginComponent,
    data: {
      title: 'Login'
    }
  },
  {
    path: 'logout',
    component: LogoutComponent,
    data: {
      title: 'Logout'
    }
  },
  {
    path: 'cadastro',
    component: CadastroComponent,
    data: {
      title: 'Cadastro'
    }
  },
  {
    path: '',
    component: FullLayoutComponent,
    data: {
      title: 'Menu'
    },
    children: [
      {
        path: 'menu',
        loadChildren: './views/inicio/inicio.module#InicioModule',
        canActivateChild: [AuthGuard]
      }, 
      {
        path: 'usuarios',
        loadChildren: './views/usuarios/usuarios.module#UsuariosModule',
        canActivateChild: [AuthGuard]
      }, 
      {
        path: 'veiculos',
        loadChildren: './views/veiculos/veiculos.module#VeiculosModule',
        canActivateChild: [AuthGuard]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

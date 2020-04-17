import { NgModule } from '@angular/core';
import { UsuariosComponent } from './usuarios.component';
import { UsuariosRoutingModule } from './usuarios-routing.module';
import { ListaComponent } from './usuarios-lista/usuarios-lista.component';
import { AppSharedModule } from 'app/components/app-shared/app-shared.module';


@NgModule({
  imports: [
    AppSharedModule,
    UsuariosRoutingModule    
  ],
  declarations: [UsuariosComponent, ListaComponent],
  bootstrap: [UsuariosComponent]
})
export class UsuariosModule { }
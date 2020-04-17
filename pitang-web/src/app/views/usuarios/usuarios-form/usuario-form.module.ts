import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ModalModule } from 'ngx-bootstrap/modal';


import { UsuarioFormComponent } from './usuario-form.component';
import { UsuarioFormRoutingModule } from './usuario-form-routing.module';
import { AppSharedModule } from 'app/components/app-shared/app-shared.module';


@NgModule({
  imports: [
    AppSharedModule,
    UsuarioFormRoutingModule
  ],
  declarations: [UsuarioFormComponent],
  bootstrap: []
})
export class UsuarioFormModule { }
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ModalModule } from 'ngx-bootstrap/modal';


import { VeiculoFormComponent } from './veiculos-form.component';
import { VeiculoFormRoutingModule } from './veiculos-form-routing.module';
import { AppSharedModule } from 'app/components/app-shared/app-shared.module';


@NgModule({
  imports: [
    AppSharedModule,
    VeiculoFormRoutingModule
  ],
  declarations: [VeiculoFormComponent],
  bootstrap: []
})
export class VeiculoFormModule { }
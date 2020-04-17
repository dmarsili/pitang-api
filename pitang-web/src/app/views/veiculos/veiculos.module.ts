import { NgModule } from '@angular/core';
import { VeiculosComponent } from './veiculos.component';
import { VeiculosRoutingModule } from './veiculos-routing.module';
import { ListaComponent } from './veiculos-lista/veiculos-lista.component';
import { AppSharedModule } from 'app/components/app-shared/app-shared.module';


@NgModule({
  imports: [
    AppSharedModule,
    VeiculosRoutingModule    
  ],
  declarations: [VeiculosComponent, ListaComponent],
  bootstrap: [VeiculosComponent]
})
export class VeiculosModule { }
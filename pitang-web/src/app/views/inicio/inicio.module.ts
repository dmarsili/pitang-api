import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { FormsModule } from '@angular/forms';
import { ModalModule } from 'ngx-bootstrap/modal';
import { BsDatepickerModule } from 'ngx-bootstrap';
import { CollapseModule } from 'ngx-bootstrap/collapse';
import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import { InicioComponent } from './inicio.component';
import { InicioRoutingModule } from './inicio-routing.module';
import { AppSharedModule } from '../../components/app-shared/app-shared.module';


@NgModule({
  imports: [   
    AppSharedModule,    
    InicioRoutingModule      
  ],
  declarations: [InicioComponent],
  bootstrap: [InicioComponent]
})
export class InicioModule { }

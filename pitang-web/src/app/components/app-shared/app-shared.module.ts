import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AlertModule } from 'ngx-bootstrap/alert/alert.module';
import { AlertaComponent } from './app-alerta.component';
import { NgxMaskModule } from 'ngx-mask';
import { UppercaseDirective } from './uppercase.directive';
import { LowercaseDirective } from './lowercase.directive';
import { TabsModule } from 'ngx-bootstrap/tabs/tabs.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ModalModule } from 'ngx-bootstrap/modal';
import { BsDatepickerModule, BsDatepickerConfig } from 'ngx-bootstrap';
import { getDatepickerConfig } from '../../objetos';

import { CollapseModule } from 'ngx-bootstrap/collapse/collapse.module';
import { AppConfirmacaoMsgModalComponent } from './app-confirmacao-msg-modal.component';
import { AppSemAcessoModalComponent } from './app-sem-acesso-modal.component';
import { AppConfirmarExclusaoModalComponent } from './app-confirmar-exclusao-modal.component';



@NgModule({
  imports: [
    CommonModule,
    TabsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,

    BsDatepickerModule.forRoot(),
    NgxMaskModule.forRoot(),
    AlertModule.forRoot(),
    ModalModule.forRoot(),
    CollapseModule.forRoot()
  ],
  exports: [
    CommonModule,
    FormsModule,
    TabsModule,
    ReactiveFormsModule,
    HttpClientModule,

    BsDatepickerModule,
    NgxMaskModule,
    AlertModule,
    ModalModule,
    CollapseModule,

    AlertaComponent,
    UppercaseDirective,
    LowercaseDirective],
  declarations: [
    AlertaComponent, UppercaseDirective, LowercaseDirective, AppConfirmacaoMsgModalComponent, AppConfirmarExclusaoModalComponent, AppSemAcessoModalComponent
  ],
  providers: [{ provide: BsDatepickerConfig, useFactory: getDatepickerConfig }],
  bootstrap: [AppConfirmarExclusaoModalComponent, AppConfirmacaoMsgModalComponent, AppSemAcessoModalComponent]
})
export class AppSharedModule {

}

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { LocationStrategy, HashLocationStrategy, registerLocaleData, getLocaleCurrencyName } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { LoadingModule, ANIMATION_TYPES } from 'ngx-loading';
import { LoadingService } from './services/loading.service';
import { AppComponent } from './app.component';

import { LOCALE_ID } from '@angular/core';
import { HTTP_INTERCEPTORS } from '@angular/common/http';



// Import containers
import {
  FullLayoutComponent,
  SimpleLayoutComponent
} from './containers';

const APP_CONTAINERS = [
  FullLayoutComponent,
  SimpleLayoutComponent
]

// Import components
import {
  AppHeaderComponent,
  AppBreadcrumbsComponent,
  AppSidebarComponent,
  AppSidebarFooterComponent,
  AppSidebarFormComponent,
  AppSidebarHeaderComponent,
  AppSidebarMinimizerComponent,
  APP_SIDEBAR_NAV
} from './components';

const APP_COMPONENTS = [
  AppHeaderComponent,
  AppBreadcrumbsComponent,
  AppSidebarComponent,
  AppSidebarFooterComponent,
  AppSidebarFormComponent,
  AppSidebarHeaderComponent,
  AppSidebarMinimizerComponent,
  APP_SIDEBAR_NAV
]

// Import directives
import {
  AsideToggleDirective,
  NAV_DROPDOWN_DIRECTIVES,
  ReplaceDirective,
  SIDEBAR_TOGGLE_DIRECTIVES
} from './directives';

const APP_DIRECTIVES = [
  AsideToggleDirective,
  NAV_DROPDOWN_DIRECTIVES,
  ReplaceDirective,
  SIDEBAR_TOGGLE_DIRECTIVES
]

// Import routing module
import { AppRoutingModule } from './app.routing';

// Import 3rd party components
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { Globals } from './globals';
import { HttpModule } from '@angular/http';
import "angular2-navigate-with-data";
import { AlertModule } from 'ngx-bootstrap/alert';
import { VeiculoService } from './services/veiculo.service';
import { UserService } from './services/user.service';
import { LoginComponent } from './views/login/login.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AutenticacaoService } from './services/autenticacao.service';
import { NgxMaskModule } from 'ngx-mask';
import { AppSharedModule } from './components/app-shared/app-shared.module';
import { AutenticacaoInterceptor } from './services/autenticacao.interceptor';
import { AuthGuard } from './services/auth-guard.service';
import localePt from '@angular/common/locales/pt';
import { CadastroComponent } from './views/cadastro/cadastro.component';
import { LogoutComponent } from './views/logout/logout.component';

registerLocaleData(localePt, 'pt');

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    BsDropdownModule.forRoot(),
    TabsModule.forRoot(),
    ChartsModule,
    HttpClientModule,
    HttpModule,
    LoadingModule,
    AppSharedModule,
    NgxMaskModule.forRoot()
  ],
  declarations: [
    AppComponent,
    LoginComponent,
    LogoutComponent,
    CadastroComponent,
    ...APP_CONTAINERS,
    ...APP_COMPONENTS,
    ...APP_DIRECTIVES
  ],
  providers: [
    AuthGuard, AutenticacaoService, Globals, LoadingService, VeiculoService, UserService,
    { provide: LocationStrategy, useClass: HashLocationStrategy },
    {
      provide: HTTP_INTERCEPTORS, useClass: AutenticacaoInterceptor,
      multi: true,
    },
    { provide: LOCALE_ID, useValue: 'pt' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

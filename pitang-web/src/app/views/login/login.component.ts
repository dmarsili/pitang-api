import { Component } from '@angular/core';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginDTO, LoginResponseDTO } from '../../objetos';
import { AutenticacaoService } from '../../services/autenticacao.service';
import { LoadingService } from '../../services/loading.service';
import { Alerta } from '../../components/app-shared/alerta';
import { Globals } from 'app/globals';

@Component({
  templateUrl: './login.component.html'
})
export class LoginComponent {

  public login: LoginDTO = new LoginDTO("", "");
  public mensagemErro: String = "";

  constructor(private autenticacaoService: AutenticacaoService, private router: Router) { }

  public efeturarLogin(login: LoginDTO) {
    this.mensagemErro = "";
    LoadingService.open();
    this.autenticacaoService.login(this.login).subscribe(retorno => {
      this.autenticacaoService.logar(retorno);
      this.router.navigate(['/menu']);
    }, error => {
      if(error.error != null && error.error.msg != null){
        this.mensagemErro = error.error.msg;      
      } else{
        this.mensagemErro = Globals.message_error_login_reg;
      }
      LoadingService.close();
    }, () => {
      LoadingService.close();
    });
  }

  isLoading(): boolean {
    return LoadingService.isLoading();
  }

  create(){
    this.router.navigate(["/cadastro"]);
  }

}
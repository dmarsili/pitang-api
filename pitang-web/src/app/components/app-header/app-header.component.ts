import { OnInit, Component } from '@angular/core';
import { AutenticacaoService } from '../../services/autenticacao.service';

@Component({
  selector: 'app-header',
  templateUrl: './app-header.component.html'
})
export class AppHeaderComponent implements OnInit {

  public nomeUsuario: string;
  public tempoExpiracao: number;
  constructor(private autenticacaoService: AutenticacaoService) { }

  ngOnInit() {    
  }

  sair() {
    this.autenticacaoService.logout();
  }

}

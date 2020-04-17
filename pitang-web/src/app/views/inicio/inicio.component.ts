import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoadingService } from '../../services/loading.service';
import { Alerta } from '../../components/app-shared/alerta';

import { Router } from '@angular/router';

@Component({
  templateUrl: './inicio.component.html'
})
export class InicioComponent {  

  public credentials = { username: '', password: '' }; 
  constructor( private http: HttpClient, private router: Router) { }

  public countList: Array<any> = [];
  public carregandoContato: boolean = true;
  public isCollapsed: boolean = false;


  ngOnInit() {
    /*
      0 - Contatos
      1 -  Endereços
      2 -  Controle de Usuários
      3 - Departamentos
      4 - Cargos
      5 -  Funcionários
      6 -  Acompanhamento
      7 -  Boletos
    */
   
    let numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8];

    for (let num of numbers) {
        this.countList[num] = { "view": true, "qtd": 0 };
    }

    this.loadQtd();
    
    /*setTimeout(() => {
        this.loadQtd();
    }, 1000);*/
}
loadQtd() {
    
    this.countList[0].view = true;
    this.countList[0].qtd = 1;
    this.countList[1].view = true;
    this.countList[1].qtd = 1;
    this.countList[2].view = true;
    this.countList[2].qtd = 1;
    this.countList[3].view = true;
    this.countList[3].qtd = 1;
    this.countList[4].view = true;
    this.countList[4].qtd = 1;
    this.countList[5].view = true;
    this.countList[5].qtd = 1;

}


}

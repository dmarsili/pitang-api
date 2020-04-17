import { Component, OnInit } from '@angular/core';
import { Alerta } from 'app/components/app-shared/alerta';
@Component({
  selector: 'app-veiculos',
  templateUrl: './veiculos.component.html'
})
export class VeiculosComponent implements OnInit {

  public alertaService: Alerta = new Alerta();
  public textoBusca: string = '';

  constructor() { }

  ngOnInit() {
  }  
}

import { Component, OnInit } from '@angular/core';
import { Alerta } from 'app/components/app-shared/alerta';
@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html'
})
export class UsuariosComponent implements OnInit {

  public alertaService: Alerta = new Alerta();
  public textoBusca: string = '';

  constructor() { }

  ngOnInit() {
  }  
}

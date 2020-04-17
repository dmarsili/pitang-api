import { Component, OnInit, Input } from '@angular/core';
import { Alerta } from './alerta';


@Component({
  selector: 'app-alerta',
  templateUrl: './app-alerta.component.html'
})
export class AlertaComponent implements OnInit {

  @Input() private service: Alerta;

  ngOnInit() {
  }

  public getAlertas(): Array<any> {    
    return this.service.getAlertas();
  }  

  public getAlertaDetalhes(): Array<any> {    
    return this.service.getAlertaDetalhes();
  } 

}

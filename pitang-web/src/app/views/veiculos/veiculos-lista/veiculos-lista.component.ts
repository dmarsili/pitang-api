import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Alerta } from 'app/components/app-shared/alerta';
import { LoadingService } from 'app/services/loading.service';
import { CarDTO } from 'app/objetos';
import { VeiculoService } from 'app/services/veiculo.service';
import { BsModalService } from 'ngx-bootstrap';
import { Globals } from 'app/globals';

@Component({
  selector: 'veiculos-lista',
  templateUrl: './veiculos-lista.component.html'
})
export class ListaComponent implements OnInit {

  @Input() alertaService: Alerta;  
  cars: Array<CarDTO> = [];
  
  constructor(private modalService: BsModalService, private route: ActivatedRoute, 
    public veiculoService: VeiculoService, private router: Router) {
  }

  ngOnInit() {
    this.getCars();
  }

  getCars() {
    LoadingService.open();
    this.veiculoService.getVeiculos().subscribe(retorno => {
      if (retorno != null && retorno.length > 0) {
        this.cars = retorno;    
      } else {
        this.alertaService.e(Globals.message_error_car_list);
      }
    }, error => {
      if(error.error != null && error.error.msg != null){
        this.alertaService.e(error.error.msg);      
      } else{
        this.alertaService.e(Globals.message_error_generic);
      }
      LoadingService.close();
    }, () => {
      LoadingService.close();
    });
  }

  edit(car:CarDTO) {
    this.router.navigate(["veiculos/formulario/" + car.carId]);
  }

}

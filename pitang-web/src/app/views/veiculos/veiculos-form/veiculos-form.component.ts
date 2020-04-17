import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { CarDTO } from 'app/objetos';
import { Alerta } from 'app/components/app-shared/alerta';
import { VeiculoService } from 'app/services/veiculo.service';
import { LoadingService } from 'app/services/loading.service';
import { Globals } from 'app/globals';
import { BsDatepickerConfig } from 'ngx-bootstrap';

@Component({
  selector: 'app-veiculo-form',
  templateUrl: './veiculos-form.component.html',
})
export class VeiculoFormComponent implements OnInit {

  public car: CarDTO = new CarDTO(0, "", "", "", "");
  public alertaService: Alerta = new Alerta();

  constructor(private route: ActivatedRoute, private router: Router, 
    private veiculoService: VeiculoService) { }

  bsConfig: BsDatepickerConfig =
  Object.assign(new BsDatepickerConfig(), {
    containerClass: 'theme-blue',
    dateInputFormat: 'DD/MM/YYYY',
    locale: 'pt-br',
    showWeekNumbers: false
  });

  ngOnInit() {
    this.getCar();
  }

  isAlteraCadastro(): boolean {
    return this.car.carId != null && this.car.carId > 0;
  }
    
  getCar() {
    let paramId: string = this.route.snapshot.paramMap.get('id');
    if (paramId == null) {      
      return;
    }

    let id = Number.parseInt(paramId);
    if (id == 0) {     
      return;
    }
    LoadingService.open();
    this.veiculoService.getVeiculo(id).subscribe(retorno => {
      if(retorno != null){
        this.car = retorno;
      } else {
        this.alertaService.e(Globals.message_error_car_list);
      }
    }, error => {
      console.log(error);
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

  save(): void {
    LoadingService.open();
    this.veiculoService.salvarVeiculo(this.car).subscribe(retorno => {
      if(retorno != null){
        this.alertaService.salvoComSucesso("Veículo");
      } else {
        this.alertaService.e(Globals.message_error_car_save);
      }
    }, error => {
      console.log(error);
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

  delete(): void {
    // LoadingService.open();
    // this.veiculoService(this.car.carId).subscribe(retorno => {
    //   if(retorno != null){
    //     this.alertaService.removidoComSucesso("Usuário");
    //   } else {
    //     this.alertaService.e(Globals.message_error_car_delete);
    //   }
    // }, error => {
    //   console.log(error);
    //   if(error.error != null && error.error.msg != null){
    //     this.alertaService.e(error.error.msg);      
    //   } else{
    //     this.alertaService.e(Globals.message_error_generic);
    //   }
    //   LoadingService.close();
    // }, () => {
    //   LoadingService.close();
    // });
  }

}

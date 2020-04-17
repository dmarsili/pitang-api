import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { UserDTO, CarDTO } from 'app/objetos';
import { Alerta } from 'app/components/app-shared/alerta';
import { UserService } from 'app/services/user.service';
import { VeiculoService } from 'app/services/veiculo.service';
import { LoadingService } from 'app/services/loading.service';
import { Globals } from 'app/globals';
import { BsDatepickerConfig } from 'ngx-bootstrap';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
})
export class UsuarioFormComponent implements OnInit {

  public user: UserDTO = new UserDTO();
  public alertaService: Alerta = new Alerta();

  constructor(private route: ActivatedRoute, private router: Router, 
    private userService: UserService) { }

  bsConfig: BsDatepickerConfig =
  Object.assign(new BsDatepickerConfig(), {
    containerClass: 'theme-blue',
    dateInputFormat: 'DD/MM/YYYY',
    locale: 'pt-br',
    showWeekNumbers: false
  });

  ngOnInit() {
    this.getUser();
  }

  isAlteraCadastro(): boolean {
    return this.user.userId != null && this.user.userId > 0;
  }
    
  getUser() {
    let paramId: string = this.route.snapshot.paramMap.get('id');
    if (paramId == null) {      
      return;
    }

    let id = Number.parseInt(paramId);
    if (id == 0) {     
      return;
    }
    LoadingService.open();
    this.userService.getUser(id).subscribe(retorno => {
      if(retorno != null){
        this.user = retorno;
      } else {
        this.alertaService.e(Globals.message_error_user_list);
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
    this.userService.saveUser(this.user).subscribe(retorno => {
      if(retorno != null){
        this.alertaService.salvoComSucesso("Usuário");
      } else {
        this.alertaService.e(Globals.message_error_user_save);
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
    LoadingService.open();
    this.userService.deleteUser(this.user.userId).subscribe(retorno => {
      if(retorno != null){
        this.alertaService.removidoComSucesso("Usuário");
      } else {
        this.alertaService.e(Globals.message_error_user_delete);
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


  setCar(car: CarDTO) {
    let index: number = this.inArray(car, this.user.cars);
    if(index > -1){
       this.user.cars.splice(index, 1);
     }else{
       this.user.cars.push(car);
     }
  }

  inArray(target, array) {
    for (var i = 0; i < array.length; i++) {
      if (array[i].id === target.id) {
        return i;
      }
    }
    return -1;
  }

  checkCarSelected(cars: Array<CarDTO>, car: CarDTO): boolean {
    if (cars == undefined) {
      return false;
    }

    for (let i = 0; i < cars.length; i++) {
      if (cars[i].carId == car.carId) {
        return true;
      }
    }
    return false;
  }


}

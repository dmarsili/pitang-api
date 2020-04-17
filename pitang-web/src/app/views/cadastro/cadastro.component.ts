import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { UserDTO, CarDTO } from 'app/objetos';
import { Alerta } from 'app/components/app-shared/alerta';
import { UserService } from 'app/services/user.service';
import { LoadingService } from 'app/services/loading.service';
import { BsDatepickerConfig } from 'ngx-bootstrap';
import { Globals } from 'app/globals';

@Component({
  selector: 'app-cadastro-form',
  templateUrl: './cadastro.component.html',
})
export class CadastroComponent implements OnInit {

  public user: UserDTO = new UserDTO();
  public car: CarDTO = new CarDTO(0, "", "","","");
  public alertaService: Alerta = new Alerta();

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) { 
  }

  bsConfig: BsDatepickerConfig =
  Object.assign(new BsDatepickerConfig(), {
    containerClass: 'theme-blue',
    dateInputFormat: 'DD/MM/YYYY',
    locale: 'pt-br',
    showWeekNumbers: false
  });

  ngOnInit() {
    let session: string = localStorage.getItem("SESSION");
    console.log("SESSION: "+session);
    if (session != null  || session != undefined || session != "undefined") {
      localStorage.removeItem("SESSION");
    }
  }
  
  login(): void{
    this.router.navigate(["/login"]);
  }

  save(): void {
    LoadingService.open();

    let carsArr:Array<CarDTO> = [];
    if(this.car != null){
      carsArr.push(this.car);
      this.user.cars = carsArr;
    }

    this.userService.saveUser(this.user).subscribe(retorno => {
      if(retorno != null){
        this.alertaService.salvoComSucesso("Usuário");
      } else {
        this.alertaService.e(Globals.message_error_reg_save);
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

}

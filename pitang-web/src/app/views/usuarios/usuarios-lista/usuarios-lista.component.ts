import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Alerta } from 'app/components/app-shared/alerta';
import { LoadingService } from 'app/services/loading.service';
import { UserDTO } from 'app/objetos';
import { UserService } from 'app/services/user.service';
import { BsModalService } from 'ngx-bootstrap';
import { Globals } from 'app/globals';

@Component({
  selector: 'usuarios-lista',
  templateUrl: './usuarios-lista.component.html'
})
export class ListaComponent implements OnInit {

  @Input() alertaService: Alerta;  
  users: Array<UserDTO> = [];
  
  constructor(private modalService: BsModalService, private route: ActivatedRoute, 
    public userService: UserService, private router: Router) {
  }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    LoadingService.open();
    this.userService.getUsers().subscribe(retorno => {
      if (retorno != null && retorno.length > 0) {
        this.users = retorno;    
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

  edit(user:UserDTO) {
    this.router.navigate(["usuarios/formulario/" + user.userId]);
  }

}

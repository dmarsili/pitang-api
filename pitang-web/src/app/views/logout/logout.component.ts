import { Component } from '@angular/core';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginDTO, LoginResponseDTO, UserDTO } from '../../objetos';
import { AutenticacaoService } from '../../services/autenticacao.service';
import { LoadingService } from '../../services/loading.service';
import { Alerta } from '../../components/app-shared/alerta';

@Component({
  templateUrl: './logout.component.html'
})
export class LogoutComponent {

  constructor(private router: Router){}

  ngOnInit() {
    localStorage.clear;
    sessionStorage.clear;
    this.router.navigate(["/login"]);
  }
    
}
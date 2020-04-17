import { Injectable } from '@angular/core';
import { CanActivateChild, CanActivate } from '@angular/router';
import { AutenticacaoService } from './autenticacao.service';
import { RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { BsModalService } from 'ngx-bootstrap/modal';
import { AppConfirmacaoMsgModalComponent } from '../components/app-shared/app-confirmacao-msg-modal.component';
import { AppSemAcessoModalComponent } from '../components/app-shared/app-sem-acesso-modal.component';
import { environment } from 'environments/environment';


@Injectable()
export class AuthGuard implements CanActivate, CanActivateChild {
    constructor(private modalService: BsModalService, private autenticacaoService: AutenticacaoService, private router: Router) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        let url: string = state.url;
        return this.checkLogin(url);
    }

    checkLogin(url: string): boolean {        
        
        if (!this.autenticacaoService.isLogado()) {            
            this.router.navigate(['login']);
            return false;
        }
        return true;
    }

    canActivateChild(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        return this.canActivate(route, state);
    }
}
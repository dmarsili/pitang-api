import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { Router } from '@angular/router';
import { LoginDTO, LoginResponseDTO } from '../objetos';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AutenticacaoService {

    constructor(private http: HttpClient, private router: Router) { }

    public login(login: LoginDTO): Observable<LoginResponseDTO> {
        return this.http.post<LoginResponseDTO>(environment.url.urlLogin, login);
    }

    public logar(session: LoginResponseDTO) {
        if (!environment.production) {
            return;
        }
        localStorage.setItem("SESSION", JSON.stringify(session));
    }

    public getToken(): string {
        if (!environment.production) {
            return null;
        }
        let loginRetorno: LoginResponseDTO = this.getSession();
        if (loginRetorno == null) {
            return null;
        }
        return loginRetorno.jwttoken;
    }

    public isLogado(): boolean {
        if (!environment.production) {
            return true;
        }
        return this.getToken() != null;
    }

    // public getTempoExpiracao(): number {
    //     // if (!environment.production) {
    //         return 30;
    //     // }

    //     // let session: LoginResponseDTO = this.getSession();
    //     // if (session == null) {
    //     //     return 0;
    //     // }
    //     // let dataExpiracao = new Date()
    //     // dataExpiracao.setDate(new Date().getDate()+1);
    //     // let agora = new Date();

    //     // let tempoMilis: number = dataExpiracao.getTime() - agora.getTime();

    //     // let tempo: number = Math.floor(tempoMilis / 1000 / 60) + 1;
    //     // if (tempo >= 0) {
    //     //     return tempo;
    //     // }

    //     // return 0;
    // }

    public logout() {  
        localStorage.removeItem("SESSION");
        this.router.navigate(['/login']);
    }

    private getSession(): LoginResponseDTO {
        console.log("GETSESSION");
        let session: string = localStorage.getItem("SESSION");
        console.log("SESSION: "+session);
        if (session == null  || session == undefined || session == "undefined") {
            return null;
        }
        let loginRetorno: LoginResponseDTO = JSON.parse(session);
        return loginRetorno;
    }  

}
import { Injectable } from '@angular/core';
import { HttpHandler, HttpEvent, HttpClient, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AutenticacaoService } from './autenticacao.service';

@Injectable()
export class AutenticacaoInterceptor implements HttpInterceptor {

    constructor(private autenticacaoService: AutenticacaoService) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        if (this.autenticacaoService.isLogado()) {
            const cloned = req.clone({
                headers: req.headers.set("Authorization", "Bearer "+this.autenticacaoService.getToken())
            });
            return next.handle(cloned);
        }
        else {
            return next.handle(req);
        }
    }


}
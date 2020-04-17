import { Injectable, Component } from '@angular/core';
import { CarDTO } from '../objetos';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'environments/environment';
import { AutenticacaoService } from './autenticacao.service';

@Injectable()
export class VeiculoService {

    constructor(private http: HttpClient, private autenticacaoService: AutenticacaoService) { }

    public getVeiculo(idVeiculo: number): Observable<CarDTO> {
        return this.http.get<CarDTO>(environment.url.urlCar + "/" + idVeiculo);
    }

    public getVeiculos(): Observable<Array<CarDTO>> {
        return this.http.get<Array<CarDTO>>(environment.url.urlCar);
    }

    public salvarVeiculo(car: CarDTO): Observable<void> {
        return this.http.post<void>(environment.url.urlCar, car);
    }


    public salvarAlteracoes(cars: Array<CarDTO>): Observable<void> {      
        return this.http.put<void>(environment.url.urlCar, cars);        
    }

}

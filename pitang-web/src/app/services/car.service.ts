import { Injectable, Component } from '@angular/core';
import { CarDTO } from '../objetos';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';

@Injectable()
export class CarService {

    constructor(private http: HttpClient) { }

    public getCar(carId: number): Observable<CarDTO> {
        return this.http.get<CarDTO>(environment.url.urlCar + "/" + carId);
    }

    public getCars(): Observable<Array<CarDTO>> {
        return this.http.get<Array<CarDTO>>(environment.url.urlCar);
    }

    public saveCar(car: CarDTO): Observable<void> {
        if(car.carId == null || car.carId == 0){
            //create
            return this.http.post<void>(environment.url.urlCar, car);
        }else{
            //update
            return this.http.put<void>(environment.url.urlCar + "/" + car.carId  , car);
        }
    }

    public deleteCar(carId: number): Observable<void> {
        return this.http.delete<void>(environment.url.urlCar + "/" + carId);
    }

}

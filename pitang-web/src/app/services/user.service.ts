import { Injectable, Component } from '@angular/core';
import { CarDTO, UserDTO } from '../objetos';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';

@Injectable()
export class UserService {

    constructor(private http: HttpClient) { }

    public getUser(userId: number): Observable<UserDTO> {
        return this.http.get<UserDTO>(environment.url.urlUser + "/" + userId);
    }

    public getUsers(): Observable<Array<UserDTO>> {
        return this.http.get<Array<UserDTO>>(environment.url.urlUser);
    }

    public saveUser(user: UserDTO): Observable<void> {
        if(user.userId == null || user.userId == 0){
            //create
            return this.http.post<void>(environment.url.urlUser, user);
        }else{
            //update
            return this.http.put<void>(environment.url.urlUser + "/" + user.userId  , user);
        }
    }

    public deleteUser(userId: number): Observable<void> {
        return this.http.delete<void>(environment.url.urlUser + "/" + userId);
    }
}

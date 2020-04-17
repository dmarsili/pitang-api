import { environment } from './environment';

export class Urls {

    urlServer: String;

    urlLogin;
    urlUser;
    urlCar;
    constructor(urlServer: String) {
        this.urlServer = urlServer;
        this.urlLogin = this.urlServer + "/api/signin";
        this.urlCar = this.urlServer + "/api/cars";
        this.urlUser = this.urlServer + "/api/users";
     }

}
import { Observable } from "rxjs/Observable";
import { BsDatepickerConfig } from "ngx-bootstrap/datepicker/bs-datepicker.config";

export class UserDTO {

	userId: number;
	firstName: string;
	lastName: string;
	email: string;
	birthday: Date;
  login: string;
  password: string;
	phone: string;
	cars: Array<CarDTO>;
}

export class CarDTO {

  carId: number;
  year: string;
  licensePlate: string;
  model: string;
  color: string;
  
  constructor(id: number, year: string, licensePlate: string, model: string, color: string) {
    this.carId = this.carId;
    this.year = year;
    this.licensePlate = licensePlate;
    this.model = model;
    this.color = color;
  }

}

export class LoginDTO {
  login: String;
  password: String;

  constructor(login: String, password: String) {
    this.login = login;
    this.password = password;
  }
}



export class Pagina {
  paginacao: object;
  dados: object;

  constructor(paginacao: object, dados: object) {
    this.paginacao = paginacao;
    this.dados = dados;
  }
}

export class Status {
  idErro: number;
  descricaoErro: string;
  sucesso: boolean;
}

export class Erro {
  campo: string;
  valorInformado: string;
  erro: string;

  constructor(campo: string, valorInformado: string, erro: string) {
    this.campo = campo;
    this.valorInformado = valorInformado;
    this.erro = erro;
  }
}

export class ResponseData<E> {
  data: E;
  status: Status;
  erros: Array<Erro> = [];

  static success(data: any): Observable<any> {
    return new Observable(observer => {
      setTimeout(() => {
        let r: ResponseData<any> = new ResponseData();
        let s: Status = new Status();
        s.sucesso = true;
        r.status = s;
        r.data = data;
        observer.next(r);
        observer.complete();
      }, 100);
    });

  }

  static erro(data: any): Observable<any> {
    return new Observable(observer => {
      setTimeout(() => {
        let r: ResponseData<any> = new ResponseData();
        let s: Status = new Status();
        s.sucesso = false;
        r.status = s;
        r.data = data;
        r.erros.push(new Erro("campo", "null", "Campo [campo] deve ser preenchido"));
        observer.next(r);
        observer.complete();
      }, 100);
    });

  }

}


export class LoginResponseDTO {
  jwttoken: string;
  dataExpiracao: Date;
  constructor(jwttoken: string){
    this.jwttoken = jwttoken;
  }
}
export function getDatepickerConfig(): BsDatepickerConfig {
  return Object.assign(new BsDatepickerConfig(), {
    containerClass: 'theme-blue',
    dateInputFormat: 'DD/MM/YYYY',
    locale: 'pt-br',
    showWeekNumbers: false
  });
}
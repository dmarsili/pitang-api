import { Erro } from "../../objetos";
import { Route } from "@angular/router";
import { Globals } from "app/globals";

export class Alerta {

  private alertas: Array<any> = [];
  private alertaDetalhes: Array<Erro> = [];

  public getAlertas() {
    return this.alertas;
  }

  public getAlertaDetalhes() {
    return this.alertaDetalhes;
  }

  private add(alerta: any) {
    window.scrollTo(0, 0);
    this.alertas.push(alerta);
  }

  public erroGenerico() {
    this.limparLogs();
    this.add({ type: "erro", msg: Globals.message_error_generic });
  }

  private limparLogs() {
    this.alertas.splice(0, this.alertas.length);
    this.alertaDetalhes.splice(0, this.alertaDetalhes.length);
  }

  /* USAR ESSAS MENSAGENS */
  public adicionadoComSucesso(objeto: String) {
    this.s(objeto + " adicionado(a) com Sucesso !");
  }

  public salvoComSucesso(objeto: String) {
    this.s(objeto + " salvo com Sucesso !");
  }

  public removidoComSucesso(objeto: String) {
    this.s(objeto + " removido(s) com Sucesso !");
  }

  public s(texto: String) {
    this.limparLogs();
    this.add({ type: "sucesso", iconClass: "fa fa-thumbs-o-up", msg: texto, timeout: 5000 });
  }

  public a(texto: String) {
    this.limparLogs();
    this.add({ type: "alerta", iconClass: "fa fa-exclamation-triangle", msg: texto, timeout: 5000 });
  }

  public i(texto: String) {
    this.limparLogs();
    this.add({ type: "informativo", iconClass: "fa fa-hand-o-right", msg: texto, timeout: 5000 });
  }

  public e(texto: String) {
    this.limparLogs();
    this.add({ type: "erro", iconClass: "fa fa-thumbs-o-down", msg: texto });
  }

  public ee(response: any) {
    this.add({ type: "erro", msg: response.error.error.msg});
  }

  public eeee(erro: any) {
    this.limparLogs();
    if (erro && erro.status == 401) {
      this.add({ type: "erro", msg: Globals.message_error_user_has_no_access });
    } else {
      this.add({ type: "erro", msg: Globals.message_error_generic });
    }
  }



}
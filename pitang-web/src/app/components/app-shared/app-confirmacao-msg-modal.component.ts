import { Component } from '@angular/core';

@Component({
    selector: 'modal-content',
    templateUrl: './app-confirmacao-msg-modal.component.html'
})
export class AppConfirmacaoMsgModalComponent {    
    msg: string;
    confirmarAction: Function;
    negarAction: Function;
}
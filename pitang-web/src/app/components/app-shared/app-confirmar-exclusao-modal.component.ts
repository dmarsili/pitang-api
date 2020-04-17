import { Component } from '@angular/core';

@Component({
    selector: 'modal-content',
    templateUrl: './app-confirmar-exclusao-modal.component.html'
})
export class AppConfirmarExclusaoModalComponent {
    quantidade: number;
    objeto: string;
    confirmarAction: Function;
    negarAction: Function;
}
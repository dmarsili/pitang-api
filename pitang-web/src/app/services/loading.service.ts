import { Injectable, Component } from '@angular/core';
import { LoadingModule, ANIMATION_TYPES } from 'ngx-loading'; // Modal Loadingw

@Injectable()
export class LoadingService {
  public static controladorModals: number = 0;
  constructor() { }

  static open() {
    setTimeout(() => {
      this.controladorModals = (this.controladorModals === undefined) ? 0 : this.controladorModals;
      this.controladorModals++;
    });
  }

  static isLoading() {
    return this.controladorModals > 0;
  }

  static close() {
    setTimeout(() => {
      this.controladorModals--;
    });
  }
}


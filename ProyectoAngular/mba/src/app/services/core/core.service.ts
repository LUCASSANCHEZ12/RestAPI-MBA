import { Injectable } from '@angular/core';
import {MatSnackBar, MatSnackBarConfig} from '@angular/material/snack-bar';
import { CustomSnackbarComponent } from '../../pages/custom-snackbar/custom-snackbar.component';

@Injectable({
  providedIn: 'root'
})
export class CoreService {

  constructor(private _snackBar: MatSnackBar) { }

  openSnackBar(message: string, action: string = "Ok") {
    this._snackBar.open(message, action, {
      duration: 2500,
      verticalPosition: 'top',
      panelClass: ['snackbar']
    });
  }

  openCustomSnackBar(message: string): void{
    this._snackBar.openFromComponent(CustomSnackbarComponent, {
      data: message,
      duration: 2500,
      verticalPosition: 'top',
      viewContainerRef: undefined,
    });
  }
}

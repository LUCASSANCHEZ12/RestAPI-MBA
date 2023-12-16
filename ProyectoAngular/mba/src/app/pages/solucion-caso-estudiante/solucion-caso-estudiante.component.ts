import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserStudyCaseComponent } from '../user-study-case/user-study-case.component';

@Component({
  selector: 'app-solucion-caso-estudiante',
  templateUrl: './solucion-caso-estudiante.component.html',
  styleUrl: './solucion-caso-estudiante.component.css'
})
export class SolucionCasoEstudianteComponent {

  constructor(private _dialog: MatDialog){
  }

  openAddEditUserForm() {
    const dialogRef = this._dialog.open(UserStudyCaseComponent);
  }
}

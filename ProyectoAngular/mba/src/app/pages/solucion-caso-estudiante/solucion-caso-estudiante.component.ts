import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserStudyCaseComponent } from '../user-study-case/user-study-case.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-solucion-caso-estudiante',
  templateUrl: './solucion-caso-estudiante.component.html',
  styleUrl: './solucion-caso-estudiante.component.css'
})
export class SolucionCasoEstudianteComponent {
  userId: string = "";
  studyCaseId: string = "";
  constructor(private _dialog: MatDialog, private route: ActivatedRoute){
    this.route.queryParams.subscribe(params => {
      this.userId = params['id'];
      this.studyCaseId = params['studyCase'];

      
      console.log("CODIGO USUARIO");
      console.log(this.userId);
      console.log("CODIGO CASO DE ESTUDIO");
      console.log(this.studyCaseId);
    });
  }

   openAddEditUserForm() {
    const dialogRef = this._dialog.open(UserStudyCaseComponent, {
      data: {
        userId: this.userId,
        studyCaseId: this.studyCaseId
      }
    });
  }
}

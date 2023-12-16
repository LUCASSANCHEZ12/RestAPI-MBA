import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-user-add-study-case',
  templateUrl: './user-add-study-case.component.html',
  styleUrl: './user-add-study-case.component.css'
})
export class UserAddStudyCaseComponent {
  idMat: string = "";

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,){
    console.log("AGREGAR USUARIOS")
    this.idMat = data.materiaId;
      console.log("CODIGO MATERIA-FORMULARIO");
      console.log(this.idMat); 
  }

  onFormSubmit() {
    console.log("SUBMIT")
  }
}

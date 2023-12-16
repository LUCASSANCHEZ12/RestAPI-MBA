import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CoreService } from '../../services/core/core.service';

@Component({
  selector: 'app-user-study-case',
  templateUrl: './user-study-case.component.html',
  styleUrl: './user-study-case.component.css'
})
export class UserStudyCaseComponent {

  userForm: FormGroup;

  constructor(private _fb: FormBuilder, 
    private _userService: UserService, 
    private _dialogRef: MatDialogRef<UserStudyCaseComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private _coreService: CoreService,){
      this.userForm = this._fb.group({});
      console.log("CODIGO USUARIO-FORMULARIO");
      console.log(data.userId); // Acceder al userId pasado
      console.log("CODIGO CASO DE ESTUDIOS-FORMULARIO");
      console.log(data.studyCaseId); // Acceder al studyCaseId pasado
    
  }

  onFormSubmit() {
    console.log("SUBMIT")
  }
}

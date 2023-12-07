import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import { UserService } from '../../services/user.service';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-user-add-edit',
  templateUrl: './user-add-edit.component.html',
  styleUrl: './user-add-edit.component.css'
})
export class UserAddEditComponent {
  userForm: FormGroup;

  cargo = [
    { value: 1, label: 'Administrador'},
    { value: 2, label: 'Docente' },
    { value: 3, label: 'Estudiante' },
  ];

  selectedCargo: number | null = null; 

  constructor(private _fb: FormBuilder, private _userService: UserService, private _dialogRef: MatDialogRef<UserAddEditComponent>){
    this.userForm = this._fb.group({
      id: 1,
      cargoId: 0,
      password: '',
      segundoNombre: '',
      codigoUsuario: 0,
      primerNombre: '',
      apellidoPaterno: '',
      codigoPrograma: '',
      apellidoMaterno: '',
      email: '',
      telefono: 0,
    });
  }

  onFormSubmit() {
    if(this.userForm.valid) {
      this._userService.addUser(this.userForm.value).subscribe({
        next: (val: any) => {
          alert('Usuario añadido correctamente.');
          this._dialogRef.close(true);
        },
        error: (err: any) => {
          console.error(err);
        },
      })
    }
  }

}

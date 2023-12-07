import { Component, Inject, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import { UserService } from '../../services/user.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { privateDecrypt } from 'crypto';

@Component({
  selector: 'app-user-add-edit',
  templateUrl: './user-add-edit.component.html',
  styleUrl: './user-add-edit.component.css'
})
export class UserAddEditComponent implements OnInit{
  userForm: FormGroup;

  cargo = [
    { value: 1, label: 'Administrador'},
    { value: 2, label: 'Docente' },
    { value: 3, label: 'Estudiante' },
  ];

  selectedCargo: number | null = null; 

  constructor(private _fb: FormBuilder, private _userService: UserService, private _dialogRef: MatDialogRef<UserAddEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any){
    this.userForm = this._fb.group({
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

  ngOnInit(): void {
    this.userForm.patchValue(this.data)
  }

  onFormSubmit() {
    if(this.userForm.valid) {
      if(this.data){
        this._userService.updateUser(this.userForm.value).subscribe({
          next: (val: any) => {
            alert('Usuario actualizado correctamente.');
            this._dialogRef.close(true);
          },
          error: (err: any) => {
            console.error(err);
          },
        })
      }else{
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

}

import { Component, Inject, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
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
  submitted = false;

  cargo = [
    { value: 1, label: 'Administrador'},
    { value: 2, label: 'Docente' },
    { value: 3, label: 'Estudiante' },
  ];

  selectedCargo: number | null = null; 

  constructor(private _fb: FormBuilder, private _userService: UserService, private _dialogRef: MatDialogRef<UserAddEditComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any){
    this.userForm = this._fb.group({
      cargoId: [null, Validators.required],
      password: '',
      segundoNombre: ['', Validators.pattern('^[a-zA-Z]+$')],
      codigoUsuario: null,
      primerNombre: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      apellidoPaterno: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      codigoPrograma: '',
      apellidoMaterno: ['', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]],
      email: ['', [Validators.required, Validators.email]],
      telefono: [null, [Validators.required, Validators.pattern('^[0-9]{8}$')]],
    });
  }

  ngOnInit(): void {
    this.userForm.patchValue(this.data)
  }

  onFormSubmit() {
    this.submitted = true;

    Object.values(this.userForm.controls).forEach(control => {
      control.markAsTouched();
    });

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

import { Component, Inject, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { AdminProgramasService } from '../../services/admin-programas.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { privateDecrypt } from 'crypto';
import { CoreService } from '../../services/core/core.service';


@Component({
  selector: 'app-crear-casos-estudio',
  templateUrl: './crear-casos-estudio.component.html',
  styleUrl: './crear-casos-estudio.component.css'
})
export class CrearCasosEstudioComponent {
  caseForm: FormGroup;
  submitted = false;

  constructor(
    private _fb: FormBuilder, 
    private _AdminService: AdminProgramasService, 
    private _dialogRef: MatDialogRef<CrearCasosEstudioComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private _coreService: CoreService,){
      this.caseForm = this._fb.group({
        codigoCasoEstudio:'',
        nombre: '',
        descripcion: '',
        codigoMateria: '',
      });
  }
  ngOnInit(): void {
    this.caseForm.patchValue(this.data)
  }
  onFormSubmit(){
    if(this.caseForm.valid) {
      if(this.data){
        console.log("ENTRANDO A UPDATE");
        console.log(this.caseForm.value);
        this._AdminService.updateCase(this.caseForm.value).subscribe({
          next: (val: any) => {
            this._coreService.openCustomSnackBar('Caso actualizado correctamente!')
            this._dialogRef.close(true);
          },
          error: (err: any) => {
            console.error(err);
          },
        })
      }else{
        this._AdminService.addCase(this.caseForm.value).subscribe({
          next: (val: any) => {
            this._coreService.openCustomSnackBar('Caso creado correctamente!')
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

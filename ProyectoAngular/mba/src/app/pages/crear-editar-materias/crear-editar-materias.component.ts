import { Component, Inject, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { AdminProgramasService } from '../../services/admin-programas.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { privateDecrypt } from 'crypto';
import { CoreService } from '../../services/core/core.service';

@Component({
  selector: 'app-crear-editar-materias',
  templateUrl: './crear-editar-materias.component.html',
  styleUrl: './crear-editar-materias.component.css'
})
export class CrearEditarMateriasComponent {
  caseForm: FormGroup;
  submitted = false;
  

  constructor(
    private _fb: FormBuilder, 
    private _AdminService: AdminProgramasService, 
    private _dialogRef: MatDialogRef<CrearEditarMateriasComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private _coreService: CoreService,){
      this.caseForm = this._fb.group({
        codigoMateria:'',
        nombre: '',
        descripcion: '',
        semestre: '',
        fechaInicio: '',
        fechaFinal: '',
      });
  }
  ngOnInit(): void {
    this.caseForm.patchValue(this.data)
  }
  onFormSubmit(){
    if(this.caseForm.valid) {
      if(this.data){
        this._AdminService.updateMateria(this.caseForm.value).subscribe({
          next: (val: any) => {
            this._coreService.openCustomSnackBar('Materia actualizada correctamente!')
            this._dialogRef.close(true);
          },
          error: (err: any) => {
            console.error(err);
          },
        })  
      }else{
        this._AdminService.createMateria(this.caseForm.value).subscribe({
          next: (val: any) => {
            this._coreService.openCustomSnackBar('Materia Creada correctamente!')
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

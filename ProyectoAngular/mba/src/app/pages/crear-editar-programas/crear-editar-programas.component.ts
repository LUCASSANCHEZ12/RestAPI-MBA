import { Component, Inject, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { AdminProgramasService } from '../../services/admin-programas.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { privateDecrypt } from 'crypto';
import { Materia } from '../../interfaces/materia';
import { CoreService } from '../../services/core/core.service';

@Component({
  selector: 'app-crear-editar-programas',
  templateUrl: './crear-editar-programas.component.html',
  styleUrl: './crear-editar-programas.component.css'
})
export class CrearEditarProgramasComponent {
  caseForm: FormGroup;
  submitted = false;
  public selectedIndexes: number[] = [];
  constructor(
    private _fb: FormBuilder, 
    private _AdminService: AdminProgramasService, 
    private _dialogRef: MatDialogRef<CrearEditarProgramasComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private _coreService: CoreService,)
    {
      this.caseForm = this._fb.group({
        codigoMateria:'',
        nombre: '',
        descripcion: '',
      });
  }
  ngOnInit(): void {
    this.caseForm.patchValue(this.data)
  }

  toggleSelection(i: number) {
    if (this.selectedIndexes.includes(i)) {
      // remove index if already selected
      this.selectedIndexes = this.selectedIndexes.filter(x => x !== i); 
    } else {
      // add index 
      this.selectedIndexes.push(i);
    }
  }
  onFormSubmit(){
    if(this.caseForm.valid) {
      if(this.data){
        this._AdminService.updateProgram(this.caseForm.value).subscribe({
          next: (val: any) => {
            this._coreService.openCustomSnackBar('Programa actualizado correctamente!')
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

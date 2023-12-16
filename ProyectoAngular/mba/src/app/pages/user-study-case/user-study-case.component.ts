import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { CoreService } from '../../services/core/core.service';
import { SolutionService } from '../../services/solution.service';
import { User } from '../../interfaces/user';

@Component({
  selector: 'app-user-study-case',
  templateUrl: './user-study-case.component.html',
  styleUrl: './user-study-case.component.css'
})
export class UserStudyCaseComponent {

  userForm: FormGroup;
  idSol: string = "";
  users: User[] = [];
  nombres: string[] = [];

  constructor(private _fb: FormBuilder, 
    private _userService: UserService, 
    private solutionService: SolutionService,
    private _dialogRef: MatDialogRef<UserStudyCaseComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private _coreService: CoreService,){
      this.userForm = this._fb.group({});
      this.idSol = data.solutionId
      console.log("CODIGO SOLUCION-FORMULARIO");
      console.log(this.idSol); 

      this.getUsers(this.idSol);  
  }

  getUsers(solutionId: string){
    this.solutionService.getUsers(solutionId).subscribe({
      next: (user) => {
        this.users = user;
        console.log(this.users)
        for (let persona of this.users) {
          this.nombres.push(`${persona.primerNombre} ${persona.segundoNombre} ${persona.apellidoPaterno} ${persona.apellidoMaterno}`);
        }
        for (let persona of this.nombres) {
          console.log(persona);
        }
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

  onFormSubmit() {
    console.log("SUBMIT")
  }
}

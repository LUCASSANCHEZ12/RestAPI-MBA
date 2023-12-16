import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserStudyCaseComponent } from '../user-study-case/user-study-case.component';
import { ActivatedRoute } from '@angular/router';
import { SolutionService } from '../../services/solution.service';
import { SolucionCasoEstudio } from '../../interfaces/solucionCasoEstudio';
import { UserAddStudyCaseComponent } from '../user-add-study-case/user-add-study-case.component';

@Component({
  selector: 'app-solucion-caso-estudiante',
  templateUrl: './solucion-caso-estudiante.component.html',
  styleUrl: './solucion-caso-estudiante.component.css'
})
export class SolucionCasoEstudianteComponent {
  userId: string = "";
  studyCaseId: string = "";
  solutionId: string = "";
  materiaId: string = "";

  constructor(private _dialog: MatDialog, private route: ActivatedRoute, private solutionService: SolutionService){
    this.route.queryParams.subscribe(params => {
      this.userId = params['id'];
      this.studyCaseId = params['studyCase'];
      this.materiaId = params['materia']
      
      console.log("CODIGO USUARIO");
      console.log(this.userId);
      console.log("CODIGO CASO DE ESTUDIO");
      console.log(this.studyCaseId);
      console.log("CODIGO MATERIA");
      console.log(this.materiaId);

      this.solutionService.getSolution(this.userId, this.studyCaseId)
      .subscribe((user: SolucionCasoEstudio) => {
        if(user == null){
          console.log("No subio solución")
        }
        else{
          this.solutionId = user.codigoSolucion.toString()
          console.log("ID de solución:")
          console.log(this.solutionId)
        }
      });
    });
  }

   openAddEditUserForm() {
    if(this.solutionId != ""){
      const dialogRef = this._dialog.open(UserStudyCaseComponent, {
        data: {
          solutionId: this.solutionId,
        }
      });
    }
    else
    {
      const dialogRef = this._dialog.open(UserAddStudyCaseComponent, {
        data: {
          materiaId: this.materiaId,
        }
      });
    }
  }
}

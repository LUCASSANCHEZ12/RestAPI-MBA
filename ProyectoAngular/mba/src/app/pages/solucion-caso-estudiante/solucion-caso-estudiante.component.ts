import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserStudyCaseComponent } from '../user-study-case/user-study-case.component';
import { ActivatedRoute } from '@angular/router';
import { SolutionService } from '../../services/solution.service';
import { SolucionCasoEstudio } from '../../interfaces/solucionCasoEstudio';
import { UserAddStudyCaseComponent } from '../user-add-study-case/user-add-study-case.component';
import { User } from '../../interfaces/user';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SolutionTuple } from '../../interfaces/solution';
import { CoreService } from '../../services/core/core.service';

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

  antecedentes: string = "";
  diagnostico: string = "";
  actoresObjetivos: string = "";
  problemaCentral: string = "";
  alternativas: string = "";
  pros: string = "";
  contras: string = "";
  planAccion: string = "";

  usuariosInvolucrados: User[] = [];
  textBoxesBloqueados: boolean = false;

  public solutionTuple: SolutionTuple | null = null;

  constructor(private _fb: FormBuilder, private _dialog: MatDialog, private route: ActivatedRoute, private solutionService: SolutionService, private _coreService: CoreService){
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
      .subscribe((solution: SolucionCasoEstudio) => {
        if(solution == null){
          console.log("No subio solución")
        }
        else{
          this.antecedentes = solution.antecedentes || "";
          this.diagnostico = solution.diagnostico || "";
          this.actoresObjetivos = solution.actoresObjetivos || "";
          this.problemaCentral = solution.problemaCentral || "";
          this.alternativas = solution.alternativas || "";
          this.pros = solution.pros || "";
          this.contras = solution.contras || "";
          this.planAccion = solution.planAccion || "";

          this.solutionId = solution.codigoSolucion.toString()
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
          id: this.userId
        }
      });
      dialogRef.afterClosed().subscribe((selectedUsers: User[]) => {
        if (selectedUsers) {
          console.log("RESPUESTA")
          console.log(selectedUsers);
          this.usuariosInvolucrados = selectedUsers;
        }
      });
    }
  }

  sendSolutionData() {
    console.log("ANTECEDENTES"+ this.antecedentes);
    console.log(this.usuariosInvolucrados);
    
    this.solutionTuple = {
      valor1: {
        codigoSolucion: 0,
        codigoCasoEstudio: parseInt(this.studyCaseId),
        calificacion: 0,
        antecedentes: this.antecedentes,
        diagnostico: this.diagnostico,
        actoresObjetivos: this.actoresObjetivos,
        problemaCentral: this.problemaCentral,
        alternativas: this.alternativas,
        pros: this.pros,
        contras: this.contras,
        planAccion: this.planAccion
      },
      valor2: this.usuariosInvolucrados
    };

    console.log(this.solutionTuple);
    

    this.solutionService.createSolution(this.solutionTuple).subscribe((response) => {
      console.log("Respuesta del servidor crear solucion:");
      console.log(response);
      this._coreService.openCustomSnackBar("Solución subida correctamente!");
      this.textBoxesBloqueados = true;
    });
  }
}

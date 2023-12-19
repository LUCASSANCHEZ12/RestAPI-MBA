import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../interfaces/user';
import { SolutionService } from '../../services/solution.service';
import { SolucionCasoEstudio } from '../../interfaces/solucionCasoEstudio';

@Component({
  selector: 'app-calificar-solucion',
  templateUrl: './calificar-solucion.component.html',
  styleUrl: './calificar-solucion.component.css'
})
export class CalificarSolucionComponent{
  userId: string = "";
  studyCaseId: string = "";
  solutionId: string = "";

  antecedentes: string = "";
  diagnostico: string = "";
  actoresObjetivos: string = "";
  problemaCentral: string = "";
  alternativas: string = "";
  pros: string = "";
  contras: string = "";
  planAccion: string = "";
  calificacion: number = 0;

  usuariosInvolucrados: User[] = [];
  nombres: string[] = [];
  textBoxesBloqueados: boolean = false;

  constructor(
    private route: ActivatedRoute, 
    private solutionService: SolutionService,
    private router: Router){
    this.route.queryParams.subscribe(params => {
      this.userId = params['id'];
      this.studyCaseId = params['studyCase'];
      this.solutionId = params['solution'];
    });

    this.solutionService.getSolutionByID(this.solutionId)
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

    this.getUsers(this.solutionId);
  };

  goBack(): void {
    this.router.navigate(['/solucionCasoDocente'], { queryParams: { id: this.userId, studyCase:  this.studyCaseId, solucion: this.solutionId} });
  }

  sendScore(): void {
    console.log("Calificar")
  }

  getUsers(solutionId: string){
    this.solutionService.getUsers(solutionId).subscribe({
      next: (user) => {
        console.log(user)
        for (let persona of user) {
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

  sendCalification()
  {
    console.log(this.calificacion)
  }
}

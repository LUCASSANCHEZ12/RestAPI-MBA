import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-calificar-solucion',
  templateUrl: './calificar-solucion.component.html',
  styleUrl: './calificar-solucion.component.css'
})
export class CalificarSolucionComponent{
  userId: string = "";
  studyCaseId: string = "";
  materiaId: string = "";

  constructor(
    private route: ActivatedRoute, 
    private router: Router){
    this.route.queryParams.subscribe(params => {
      this.userId = params['id'];
      this.studyCaseId = params['studyCase'];
      this.materiaId = params['materia'];
    });
  }

  goBack(): void {
    this.router.navigate(['/solucionCasoDocente'], { queryParams: { id: this.userId, studyCase:  this.studyCaseId, materia: this.materiaId} });
  }
}

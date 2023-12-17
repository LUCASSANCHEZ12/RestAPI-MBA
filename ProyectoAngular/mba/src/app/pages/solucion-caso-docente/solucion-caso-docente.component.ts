import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { TeacherSolutionService } from '../../services/teacher-solution.service';

@Component({
  selector: 'app-solucion-caso-docente',
  templateUrl: './solucion-caso-docente.component.html',
  styleUrl: './solucion-caso-docente.component.css'
})
export class SolucionCasoDocenteComponent implements OnInit {

  userId: string = "";
  studyCaseId: string = "";
  materiaId: string = "";
  displayedColumns: string[] = [
    'CodigoSolucion', 
    'Estudiantes', 
    'Calificacion',
    'Action',
  ];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private _teacherSolutionService: TeacherSolutionService
    ){
    this.route.queryParams.subscribe(params => {
      this.userId = params['id'];
      this.studyCaseId = params['studyCase'];
      this.materiaId = params['materia'];
  });
  }
  
  ngOnInit(): void{
    this.getSolutionsStudycases(this.studyCaseId);
  }

  getSolutionsStudycases(studyCaseId: string) {
    this._teacherSolutionService.getSolutionStudyCases(studyCaseId).subscribe({
      next: (res) => {
        if (res && res.length > 0) {
          const usersData: { codigoSolucion: number, nombresEstudiantes: string[], calificacion: number }[] = [];

          res.forEach(solucion => {
            console.log(solucion.codigoSolucion);
            this._teacherSolutionService.getUsersSolutionStudyCase(solucion.codigoSolucion.toString()).subscribe({
              next: (usuarios) => {
                console.log(usuarios);

                const nombresEstudiantes = usuarios.map(usuario => `${usuario.primerNombre} ${usuario.apellidoPaterno}`);

                usersData.push({
                  codigoSolucion: solucion.codigoSolucion,
                  nombresEstudiantes: nombresEstudiantes,
                  calificacion: solucion.calificacion,
                });

                this.dataSource = new MatTableDataSource(usersData);
                this.dataSource.sort = this.sort;
                this.dataSource.paginator = this.paginator;
              },
              error: (err) => {
                console.log(err);
              }
            });
          });
        } else {
          console.log('La lista de soluciones está vacía');
        }
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  
  goBack(): void {
    this.router.navigate(['/casosDocente'], { queryParams: { id: this.userId, materia: this.materiaId } });
  }

  goScoreSolutionSolutionStudyCase(idSolution: string){    
    this.router.navigate(['/calificarSolucion'], { queryParams: { id: this.userId, studyCase: this.studyCaseId, solution:  idSolution} });
  }
}
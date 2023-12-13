import { StudyCasesService } from '../../services/study-cases.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-casos-estudiantes',
  templateUrl: './casos-estudiantes.component.html',
  styleUrl: './casos-estudiantes.component.css'
})

export class CasosEstudiantesComponent {
  userId: string = "";
  materiaId: string = "";

  displayedColumns: string[] = [
    'CodigoCasoEstudio', 
    'CodigoMateria', 
    'Nombre', 
    'Descripcion',
  ];

  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private studyCaseService: StudyCasesService){
    this.route.queryParams.subscribe(params => {
      this.userId = params['id'];
      this.materiaId = params['materia'];
  
      console.log("VER CASOS DE ESTUDIO");
      console.log("CODIGO USUARIO");
      console.log(this.userId);

      console.log("CODIGO MATERIA");
      console.log(this.materiaId);
    });
  }

  ngOnInit(): void{
    this.getStudycases(this.materiaId);
  }

  /*callGetStudyCasesWhenReady(): void {
    const checkMateriaId = () => {
      return new Promise<void>((resolve) => {
        if (this.materiaId !== undefined) {
          resolve();
        } else {
          setTimeout(() => {
            checkMateriaId().then(resolve);
          }, 100); // Espera 100 milisegundos antes de verificar nuevamente
        }
      });
    };
  
    checkMateriaId().then(() => {
      this.getStudycases(this.materiaId);
    });
  }*/

  getStudycases(materiaId: string){
    this.studyCaseService.getStudyCases(materiaId).subscribe({
      next: (res) => {
        console.log(res)
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  
  goBack(): void {
    this.router.navigate(['/materiasEstudiante'], { queryParams: { id: this.userId } });
  }

  goSolutionStudyCase(idMateria: string){
    this.router.navigate(['/casosEstudiante'], { queryParams: { id: this.userId, materia: idMateria } });
  }
}

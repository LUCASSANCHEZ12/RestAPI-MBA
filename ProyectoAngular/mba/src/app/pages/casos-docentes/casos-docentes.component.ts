import { TeacherCasesService } from '../../services/teacher-cases.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-casos-docentes',
  templateUrl: './casos-docentes.component.html',
  styleUrl: './casos-docentes.component.css'
})

export class CasosDocentesComponent {
  userId: string = "";
  materiaId: string = "";

  displayedColumns: string[] = [
    'CodigoCasoEstudio', 
    'Nombre', 
    'Descripcion',
    'Action',
  ];

  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private route: ActivatedRoute, 
    private router: Router,
    private teacherCaseService: TeacherCasesService){
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

  getStudycases(materiaId: string){
    this.teacherCaseService.getStudyCases(materiaId).subscribe({
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
    this.router.navigate(['/materiasDocente'], { queryParams: { id: this.userId } });
  }

  goSolutionStudyCase(idStudyCase: string){
    this.router.navigate(['/solucionCasoDocente'], { queryParams: { id: this.userId, studyCase:  idStudyCase} });
  }
}



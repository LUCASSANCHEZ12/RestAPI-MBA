import { Component, ViewChild } from '@angular/core';
import { UserTuple } from '../../interfaces/userTuple';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { MatDialog } from '@angular/material/dialog';
import { SubjectService } from '../../services/subject.service';

@Component({
  selector: 'app-materias-docente',
  templateUrl: './materias-docente.component.html',
  styleUrl: './materias-docente.component.css'
})
export class MateriasDocenteComponent {
  userId: string = "";
  cargoId: string = "";
  public usuario: UserTuple | null = null;

  displayedColumns: string[] = [
    'CodigoMateria', 
    'Nombre', 
    'Semestre', 
    'FechaInicio',
    'FechaFinal', 
    'Action',
  ];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private route: ActivatedRoute, private userService: UserService, private _dialog: MatDialog, private router: Router, private subjectService: SubjectService){
    this.route.queryParams.subscribe(params => {
      this.userId = params['id'];
  
      console.log("VER MATERIAS");
      console.log("CODIGO USUARIO");
      console.log(this.userId);
  
      this.userService.getUser(this.userId)
        .subscribe((user: UserTuple) => {
          this.cargoId = user.valor1.cargoId.toString();
          console.log("CODIGO CARGO");
          console.log(this.cargoId);
  
          this.callGetSubjectsWhenReady();
        });
    });
  }
  
  callGetSubjectsWhenReady(): void {
    const checkCargoId = () => {
      return new Promise<void>((resolve) => {
        if (this.cargoId !== null && this.cargoId !== undefined) {
          resolve();
        } else {
          setTimeout(() => {
            checkCargoId().then(resolve);
          }, 100); // Espera 100 milisegundos antes de verificar nuevamente
        }
      });
    };
  
    checkCargoId().then(() => {
      this.getSubjects(this.cargoId, this.userId);
    });
  }

  getSubjects(cargoId: string, userId: string){
    this.subjectService.getSubjects(cargoId, userId).subscribe({
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
    this.router.navigate(['/homeTeacher'], { queryParams: { id: this.userId } });
  }

  goStudyCase(idMateria: string){
    this.router.navigate(['/casosDocente'], { queryParams: { id: this.userId, materia: idMateria } });
  }
}

import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { CoreService } from '../../services/core/core.service';
import { CrearEditarMateriasComponent } from '../crear-editar-materias/crear-editar-materias.component';
import { AdminProgramasService } from '../../services/admin-programas.service';

@Component({
  selector: 'app-admin-materias',
  templateUrl: './admin-materias.component.html',
  styleUrl: './admin-materias.component.css'
})
export class AdminMateriasComponent {
  userId: string = "";
  displayedColumns: string[] = ['codigoMateria', 
                                'nombre',
                                'codigoDocente',
                                'semestre',
                                'fechaInicio',
                                'fechaFinal',
                                'Action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private _dialog: MatDialog, 
    private _adminService: AdminProgramasService,
    private _coreService: CoreService){
    this.route.queryParams.subscribe(params => {
      this.userId = params['id'];
  });
  }

  ngOnInit(): void{
    this.getMateriasAll();
  }

  goBack(): void {
    this.router.navigate(['/adminProgramas'], { queryParams: { id: this.userId } });
  }

  oppenAddEditCasosEstudioForm(){
    const dialogRef = this._dialog.open(CrearEditarMateriasComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getMateriasAll();
        }
      },
    });
  }
  getMateriasAll(){
    this._adminService.getMaterias().subscribe({
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

  deleteCase(id: string) {

  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  openEditCaseForm(data: any) {
    const dialogRef = this._dialog.open(CrearEditarMateriasComponent, {
    data,
    });
    
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getMateriasAll();
        }
      },
    });
  }
}

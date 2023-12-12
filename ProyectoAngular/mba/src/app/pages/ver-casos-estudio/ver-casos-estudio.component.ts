import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { CoreService } from '../../services/core/core.service';
import { CrearCasosEstudioComponent } from '../crear-editar-casos-estudio/crear-casos-estudio.component';
import { AdminProgramasService } from '../../services/admin-programas.service';


@Component({
  selector: 'app-ver-casos-estudio',
  templateUrl: './ver-casos-estudio.component.html',
  styleUrl: './ver-casos-estudio.component.css'
})
export class VerCasosEstudioComponent {
  
  userId: string = "";

  displayedColumns: string[] = [
    'CodigoCaso', 
    'Nombre', 
    'Descripcion', 
    'CodigoMateria',
    'Action',
  ];
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
    this.getCases();
  }

  goBack(): void {
    this.router.navigate(['/adminProgramas'], { queryParams: { id: this.userId } });
  }

  oppenAddEditCasosEstudioForm(){
    const dialogRef = this._dialog.open(CrearCasosEstudioComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getCases();
        }
      },
    });
  }
  getCases(){
    this._adminService.getAllCases().subscribe({
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
    this._adminService.deleteCase(id).subscribe({
      next: (res) => {
        this._coreService.openCustomSnackBar("Caso eliminado correctamente!");
        this.getCases();
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
  openEditCaseForm(data: any) {
    const dialogRef = this._dialog.open(CrearCasosEstudioComponent, {
    data,
    });
    
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getCases();
        }
      },
    });
  }
}

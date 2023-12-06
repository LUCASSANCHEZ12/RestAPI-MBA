import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import { AdminProgramasService } from '../../services/admin-programas.service';
import { Router } from '@angular/router';
import { ControlContainer } from '@angular/forms';

@Component({
  selector: 'app-admin-programas',
  templateUrl: './admin-programas.component.html',
  styleUrls: ['./admin-programas.component.css']
})

export class AdminProgramasComponent implements AfterViewInit{

  constructor(private adminServirce: AdminProgramasService, private router: Router){
    this.dataSource = new MatTableDataSource<any>();
  }
  
  displayedColumns: string[] = ['codigoPrograma', 'nombre', 'descripcion','action'];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.getProgramsList();
  }

  getProgramsList(){
    this.adminServirce.getPrograms().subscribe({
      next: (res) => {
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
  }
  click(row: any){
    const codigoPrograma = row.codigoPrograma;
    console.log(codigoPrograma);
  }
  back(){
    this.router.navigate(['/homeAdmi'], {  });
  }
  crearProgramas(){
    this.router.navigate(['/createProgram'], {  });
  }
  crearMaterias(){
    this.router.navigate(['/createMateria'], {  });
  }
}
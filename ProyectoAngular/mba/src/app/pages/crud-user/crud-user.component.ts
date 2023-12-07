import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserAddEditComponent } from '../user-add-edit/user-add-edit.component';
import { UserService } from '../../services/user.service';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { User } from '../../interfaces/user';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-crud-user',
  templateUrl: './crud-user.component.html',
  styleUrl: './crud-user.component.css'
})
export class CrudUserComponent implements OnInit {

  userId: string = "";
  displayedColumns: string[] = [
    'CodigoUsuario', 
    'PrimerNombre', 
    'SegundoNombre', 
    'ApellidoPaterno',
    'ApellidoMaterno', 
    'Telefono', 
    'Email', 
    'Cargo',
    'CodigoPrograma',
    'Action',
  ];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private route: ActivatedRoute, private router: Router, private _dialog: MatDialog, private userService: UserService){
    this.route.queryParams.subscribe(params => {
      this.userId = params['id'];
  });
  }

  ngOnInit(): void{
    this.getUsers();
  }

  goBack(): void {
    this.router.navigate(['/homeAdmi'], { queryParams: { id: this.userId } });
  }

  openAddEditUserForm() {
    this._dialog.open(UserAddEditComponent);
  }

  getUsers(){
    this.userService.getAllUsers().subscribe({
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

  deleteUser(id: string) {
    this.userService.deleteUser(id).subscribe({
      next: (res) => {
        alert('Usuario eliminado')
        this.getUsers();
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

  openEditUserForm(data: any) {
    const dialogRef = this._dialog.open(UserAddEditComponent, {
    data,
    });
    
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val) {
          this.getUsers();
        }
      },
    });
  }
}

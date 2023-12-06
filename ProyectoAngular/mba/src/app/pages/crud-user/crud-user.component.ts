import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserAddEditComponent } from '../user-add-edit/user-add-edit.component';

@Component({
  selector: 'app-crud-user',
  templateUrl: './crud-user.component.html',
  styleUrl: './crud-user.component.css'
})
export class CrudUserComponent {

  constructor(private _dialog: MatDialog){}

  openAddEditUserForm() {
    this._dialog.open(UserAddEditComponent);
  }

}

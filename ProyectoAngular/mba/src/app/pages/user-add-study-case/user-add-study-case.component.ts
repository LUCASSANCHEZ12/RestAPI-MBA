import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { SubjectService } from '../../services/subject.service';
import { User } from '../../interfaces/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-add-study-case',
  templateUrl: './user-add-study-case.component.html',
  styleUrl: './user-add-study-case.component.css'
})
export class UserAddStudyCaseComponent {
  idMat: string = "";
  id: string = "";
  users: User[] = [];
  selectedUserIds: number[] = []; // Arreglo para almacenar los IDs de usuarios seleccionados

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private subjectsService: SubjectService, private userService: UserService, private dialogRef: MatDialogRef<UserAddStudyCaseComponent>){
    this.idMat = data.materiaId;
    this.id = data.id;
    this.getUsers(this.idMat, this.id);
  }

  getUsers(materiaId: string, ID: string){
    this.subjectsService.getUsers(materiaId,ID).subscribe({
      next: (users) => {
        this.users = users;
      },
      error: (err) => {
        console.log(err);
      }
    })

    this.userService.getUser(ID).subscribe({
      next: (user) => {
        this.users.push(user.valor1);
        this.selectedUserIds.push(Number(ID));
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

  onFormSubmit() {
    const selectedUsers = this.users.filter(user => this.selectedUserIds.includes(user.codigoUsuario));
    console.log(selectedUsers); // Acción con usuarios seleccionados
    console.log("SUBMIT");
    this.dialogRef.close(selectedUsers);
  }

  toggleUserSelection(userId: number) {
    if (this.selectedUserIds.includes(userId)) {
      this.selectedUserIds = this.selectedUserIds.filter(id => id !== userId); // Desmarcar usuario
    } else {
      this.selectedUserIds.push(userId); // Marcar usuario
    }
  }
}

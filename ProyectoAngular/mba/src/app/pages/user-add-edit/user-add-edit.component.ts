import { Component } from '@angular/core';

@Component({
  selector: 'app-user-add-edit',
  templateUrl: './user-add-edit.component.html',
  styleUrl: './user-add-edit.component.css'
})
export class UserAddEditComponent {
  /*
  cargo: String [] = [
    'Docente',
    'Estudiante',
  ];
  */
  cargo = [
    { value: 1, label: 'Administrador' },
    { value: 2, label: 'Docente' },
    { value: 3, label: 'Estudiante' },
  ];

  selectedCargo: number | null = null; 

}

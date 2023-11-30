import { Component } from '@angular/core';
import { TaskService } from '../../services/task.service';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  inputValue: string = ''; // Propiedad que almacenará el valor del input

  mostrarValor() {
    console.log(this.inputValue);
    return this.inputValue; // Muestra el valor en la consola
    // O puedes hacer cualquier otra cosa con this.inputValue aquí
  }

  constructor(
    private taskService: TaskService,
    private loginComponent: LoginComponent
  ) {}

  getAllTasks() {
    this.taskService.getAllTasks()
    .subscribe(tasks => {
      console.log(tasks);
    });
  }

  getTask() {
    this.taskService.getTask(this.loginComponent.mostrarValor())
    .subscribe(task => {
      console.log(task);
    });
  }
}

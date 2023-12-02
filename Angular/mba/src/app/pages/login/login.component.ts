import { Component, ElementRef, ViewChild } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../interfaces/user';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css', './normalize.css']
})
export class LoginComponent {
  public codigo: string; // Cambié el tipo a string ya que el input es de tipo text
  //private userService: UserService;
  @ViewChild('codeInput')
  codeInput!: ElementRef<HTMLInputElement>; // Asegúrate de que el tipo coincida con el tipo de elemento que estás obteniendo

  constructor(private userService: UserService){
    this.codigo = ''; // Inicializado como string vacío
    console.log("Componente iniciado");
  }

  click() {
    this.codigo = this.codeInput.nativeElement.value; // Obtiene el valor del input
    console.log('Valor del código:', this.codigo);
    this.getUser(this.codigo);
    this.getAllUsers();
  }

  getAllUsers(){
    console.log('entré')
    this.userService.getAllUsers()
    .subscribe(users => {
      console.log(users);
    })
    console.log('salí')
  }

  getUser(id: string){
    console.log('entré');
    (this.userService.getUser(id))
    .subscribe((user: User) => {
      console.log('recibiendo')
      console.log(user);
    })
    console.log('salí')
  }
}

import { Component, ElementRef, ViewChild } from '@angular/core';
import { UserService } from '../../services/user.service';
import { UserTuple } from '../../interfaces/userTuple';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  public codigo: string; 
  public contrasena: string;
  @ViewChild('codeInput')
  codeInput!: ElementRef<HTMLInputElement>; 
  @ViewChild('passwordInput')
  passInput!: ElementRef<HTMLInputElement>; 
  public usuario: UserTuple | null;
  
  constructor(private userService: UserService, private router: Router){
    this.codigo = '';
    this.contrasena = '';
    this.usuario = null;
  }

  click() {
    this.codigo = this.codeInput.nativeElement.value;
    this.contrasena = this.passInput.nativeElement.value;
    
    if (this.codigo !== '' && this.contrasena !== '') {
      if (this.esStringNumerico(this.codigo)) {
        this.getUser(this.codigo);
      } else {
        alert('El código debe ser un número');
      }
    } else {
      alert('Llena todos los campos por favor');
    }
  }

  getUser(id: string){
    console.log('entré');
    this.userService.getUser(id)
      .subscribe((user: UserTuple | null) => {
        if (user === null) {
          alert('El código y contraseña ingresados no corresponden a ningún usuario');
        }
        else if (user.valor1.password != this.contrasena) {
          alert('La contraseña ingresada no corresponde al usuario del código ingresado')
        } 
        else {
          this.usuario = user;
          console.log(user);
          console.log('Revisar cargo');
          this.redirigir(user);
        }
      });
  }

  esStringNumerico(texto: string): boolean {
    // Expresión regular que verifica si el string contiene solo números
    const regex = /^[0-9]+$/;
    return regex.test(texto);
  }

  redirigir(usuario: UserTuple){
    switch(usuario.valor2.cargoID){
      case 1:
        this.router.navigate(['/homeAdmi'], { queryParams: { id: usuario.valor1.codigoUsuario } });
        console.log("ADMIN");
        break;
      case 2:
        console.log("DOCENTE");
        this.router.navigate(['/homeTeacher'], { queryParams: { id: usuario.valor1.codigoUsuario } });
        break;
      case 3:
        console.log("ESTUDIANTE");
        this.router.navigate(['/homeStudent'], { queryParams: { id: usuario.valor1.codigoUsuario } });
        break;
    }
  }
}

import { Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserTuple } from '../../interfaces/userTuple';
import { UserService } from '../../services/user.service';
import { User } from '../../interfaces/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  userId: string = "";
  cargoId: number = 0;
  public usuario: UserTuple | null = null;
  public user: User | null = null;

  @ViewChild('pNombreInput')
  pNombreInput!: ElementRef<HTMLInputElement>; 
  @ViewChild('sNombreInput')
  sNombreInput!: ElementRef<HTMLInputElement>; 
  @ViewChild('aPaternoInput')
  aPaternoInput!: ElementRef<HTMLInputElement>;
  @ViewChild('aMaternoInput')
  aMaternoInput!: ElementRef<HTMLInputElement>;
  @ViewChild('telefonoInput')
  telefonoInput!: ElementRef<HTMLInputElement>;
  @ViewChild('emailInput')
  emailInput!: ElementRef<HTMLInputElement>;    
  @ViewChild('contrasenaInput')
  contrasenaInput!: ElementRef<HTMLInputElement>;
  public primerNombre: string; 
  public segundoNombre: string; 
  public apellidoPaterno: string;
  public apellidoMaterno: string;
  public telefono: number;
  public email: string;
  public contrasena: string;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) {
    this.route.queryParams.subscribe(params => {
        this.userId = params['id'];
    });

    this.primerNombre = "";
    this.segundoNombre = "";
    this.apellidoPaterno = "";
    this.apellidoMaterno = "";
    this.telefono = 0;
    this.email = "";
    this.contrasena = "";

    console.log("PROFILE")
    console.log(this.userId)

    this.userService.getUser(this.userId)
      .subscribe((user: UserTuple) => {
        this.usuario = user
        console.log(this.usuario)
      });
  }

  navigateBack() {
    switch (this.usuario?.valor1.cargoId) {
      case 1:
        if (this.usuario && this.usuario.valor1 && this.usuario.valor1.codigoUsuario) {
          this.router.navigate(['/homeAdmi'], { queryParams: { id: this.usuario.valor1.codigoUsuario } });
        } 
        break;
      case 2:
        if (this.usuario && this.usuario.valor1 && this.usuario.valor1.codigoUsuario) {
          this.router.navigate(['/homeTeacher'], { queryParams: { id: this.usuario.valor1.codigoUsuario } });
        } 
        break;
      case 3:
        if (this.usuario && this.usuario.valor1 && this.usuario.valor1.codigoUsuario) {
          this.router.navigate(['/homeStudent'], { queryParams: { id: this.usuario.valor1.codigoUsuario } });
        } 
        break;
    }
  }

  update(){
    console.log("ACTUALIZAR")
    this.user = this.usuario ? this.usuario.valor1 : null;
    this.primerNombre = this.pNombreInput.nativeElement.value;
    this.segundoNombre = this.sNombreInput.nativeElement.value;
    this.apellidoPaterno = this.aPaternoInput.nativeElement.value;
    this.apellidoMaterno = this.aMaternoInput.nativeElement.value;
    this.telefono = parseInt(this.telefonoInput.nativeElement.value, 10);
    this.email = this.emailInput.nativeElement.value;
    this.contrasena = this.contrasenaInput.nativeElement.value;

    if(this.user != null)
    {
      this.user.primerNombre = this.primerNombre;
      this.user.segundoNombre = this.segundoNombre;
      this.user.apellidoPaterno = this.apellidoPaterno;
      this.user.apellidoMaterno = this.apellidoMaterno;
      this.user.telefono = this.telefono;
      this.user.email = this.email;
      this.user.password = this.contrasena;

      this.updateUser(this.user);
      console.log(this.user);
    }
  }

  updateUser(user: User){
    console.log('entré');
    this.userService.updateUser(user)
      .subscribe((user: User) => {
        alert("Los datos del usuario se han actualizado correctamente!")
        console.log(user);
      });
  }
}

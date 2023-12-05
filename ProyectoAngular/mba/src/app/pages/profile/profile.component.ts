import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../interfaces/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  userId: string = "";
  cargoId: number = 0;
  public usuario: User | null = null;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) {
    this.route.queryParams.subscribe(params => {
        this.userId = params['id'];
    });

    console.log("PROFILE")
    console.log(this.userId)

    this.userService.getUser(this.userId)
      .subscribe((user: User) => {
        this.usuario = user
        console.log(this.usuario)
        this.cargoId = this.usuario.valor1.cargoId
      });
  }

  navigateBack() {
    switch (this.cargoId) {
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
}

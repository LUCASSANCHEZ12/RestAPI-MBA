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
      });
  }

  navigateBack() {
    switch (this.cargoId) {
      case 1:
        this.router.navigate(['/homeAdmi']);
        break;
      case 2:
        this.router.navigate(['/homeTeacher']);
        break;
      case 3:
        this.router.navigate(['/homeStudent']);
        break;
    }
  }
}

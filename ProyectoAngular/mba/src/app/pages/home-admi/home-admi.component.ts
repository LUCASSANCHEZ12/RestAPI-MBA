import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home-admi',
  templateUrl: './home-admi.component.html',
  styleUrl: './home-admi.component.css'
})
export class HomeAdmiComponent {
  userId: string = "";

  constructor(private route: ActivatedRoute, private router: Router) {
    this.route.queryParams.subscribe(params => {
        this.userId = params['id'];
    });
    console.log(this.userId)
  }
}

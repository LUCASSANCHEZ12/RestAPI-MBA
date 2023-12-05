import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home-teacher',
  templateUrl: './home-teacher.component.html',
  styleUrl: './home-teacher.component.css'
})
export class HomeTeacherComponent {
  userId: string = "";

  constructor(private route: ActivatedRoute) {
    this.route.queryParams.subscribe(params => {
        this.userId = params['id'];
    });
    console.log(this.userId)
  }
}

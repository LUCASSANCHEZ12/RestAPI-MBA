import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home-student',
  templateUrl: './home-student.component.html',
  styleUrl: './home-student.component.css'
})
export class HomeStudentComponent {
  userId: string = "";

  constructor(private route: ActivatedRoute) {
    this.route.queryParams.subscribe(params => {
        this.userId = params['id'];
    });
    console.log(this.userId)
  }
}

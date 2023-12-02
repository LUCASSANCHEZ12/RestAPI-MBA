import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Task } from './../interfaces/task';



@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private api = 'http://24.144.89.34:8080/MBA/Chatbot';

  constructor(
    private http: HttpClient
  ) { }

  getAllTasks() {
    const path = `${this.api}/getall/`;
    return this.http.get<Task[]>(path);
  }

  getTask(id: string) {
    const path = `${this.api}/login/${id}`;
    return this.http.get<Task>(path);
  }
}

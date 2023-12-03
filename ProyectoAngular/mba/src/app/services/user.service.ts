import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private api = 'http://24.144.89.34:8080/MBA/Chatbot';

  constructor(private http: HttpClient) { }

  getUser(id: string) {
    const path = this.api + "/login/" + id;
    console.log(path);
    try {
      const response = this.http.get<User>(path);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }
}

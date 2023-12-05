import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private api = 'http://24.144.89.34:8080/MBA/user';

  constructor(private http: HttpClient) { }

  getUser(id: string) {
    const path = this.api + "/getUser/" + id;
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

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserTuple } from '../interfaces/userTuple';
import { User } from '../interfaces/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private api = 'http://24.144.89.34:8080/MBA/user';

  constructor(private http: HttpClient) { }

  addUser(data: any): Observable <any> {
    const path = this.api + "/create";
    return this.http.post(path, data);
  }


  getUser(id: string) {
    const path = this.api + "/getUser/" + id;
    console.log(path);
    try {
      const response = this.http.get<UserTuple>(path);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }

  updateUser(user: User): Observable<User> {
    const path = this.api + "/update";
    console.log(path);
    try {
      const response = this.http.put<User>(path,user);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }
  
  getAllUsers(): Observable<User[]>{
    const path = this.api + "/getall";
    console.log(path);
    try{
      const response = this.http.get<User[]>(path);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }

  deleteUser(id: string): Observable<User>{
    const path = this.api + "/delete/" + id;
    console.log(path);
    try{
      const response = this.http.delete<User>(path);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private api = 'http://24.144.89.34:8080/MBA/Chatbot';

  constructor(
    private http: HttpClient
  ) { }

  getAllUsers() {
    const path = this.api + "/getall";
    console.log(path);
    return this.http.get<User[]>(path);
  }

  getUser(id: string) {
    const path = this.api + "/login/" + id;
    console.log(path); // Verifica que la URL sea la esperada
    try {
      const response = this.http.get<User>(path);
      console.log(response); // Verifica la respuesta en la consola
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error); // Muestra errores si los hay
      throw error; // Propaga el error para manejarlo en otro lugar si es necesario
    }
  }
}

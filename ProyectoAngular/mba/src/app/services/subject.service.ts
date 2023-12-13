import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Materia } from '../interfaces/materia';


@Injectable({
  providedIn: 'root'
})
export class SubjectService {

  private api = 'http://24.144.89.34:8080/MBA/program';

  constructor(private http: HttpClient) { }

  getSubjects(idCargo: string, idUser: string): Observable<Materia[]>{
    const path = `${this.api}/user/${idCargo}/materias/${idUser}`;
    console.log(path);
    try{
      const response = this.http.get<Materia[]>(path);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }
}

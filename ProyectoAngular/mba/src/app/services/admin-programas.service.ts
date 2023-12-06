import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Materia } from '../interfaces/materia';
import { Observable } from 'rxjs';
import { AdminProgramas } from '../interfaces/program';
@Injectable({
  providedIn: 'root'
})
export class AdminProgramasService {

  private api = 'http://24.144.89.34:8080/MBA/program';

  constructor(private http: HttpClient) { }

  getPrograms(): Observable<any>{
    return this.http.get('http://24.144.89.34:8080/MBA/program/getall');
  }

  getMaterias(): Observable<any>{
    return this.http.get('http://24.144.89.34:8080/MBA/program/materia/getall');
  }

  createProgram(data: any) {
    const path = this.api + "/create";
    console.log(path);
    try {
      const response = this.http.post<AdminProgramas>(path,data);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }

  addMaterias(id: string, data: Materia []): Observable<any> {
    const path = this.api + "/materia/asign/" + id;
    console.log(path);
    try {
      const response = this.http.post<AdminProgramas>(path,data);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }

  createMateria(data: any) : Observable<any>{
    const path = this.api + "/materia/create";
    console.log(path);
    try {
      const response = this.http.post<AdminProgramas>(path,data);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }
}

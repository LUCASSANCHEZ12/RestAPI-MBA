import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SolucionCasoEstudio } from '../interfaces/solucionCasoEstudio';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class TeacherSolutionService {

  private api = 'http://24.144.89.34:8080/MBA/cde';

  constructor(private http: HttpClient) { }

  getSolutionStudyCases(idStudyCase: string): Observable<SolucionCasoEstudio[]>{
    const path = `${this.api}/get/soluciones/${idStudyCase}`;
    console.log('URL solicitada:', path);
    console.log(path);
    try{
      const response = this.http.get<SolucionCasoEstudio[]>(path);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }

  getUsersSolutionStudyCase(idSolutionStudyCase: string): Observable<User[]>{
    const path = `${this.api}/usuarios/solucion/${idSolutionStudyCase}`;
    console.log('URL solicitada:', path);
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
}


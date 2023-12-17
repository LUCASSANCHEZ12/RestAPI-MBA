import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StudyCase } from '../interfaces/study-case';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeacherCasesService {

  private api = 'http://24.144.89.34:8080/MBA/cde';

  constructor(private http: HttpClient) { }

  getStudyCases(idMateria: string): Observable<StudyCase[]>{
    const path = `${this.api}/materia/getall/cde/${idMateria}`;
    console.log('URL solicitada:', path);
    console.log(path);
    try{
      const response = this.http.get<StudyCase[]>(path);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }


  
}

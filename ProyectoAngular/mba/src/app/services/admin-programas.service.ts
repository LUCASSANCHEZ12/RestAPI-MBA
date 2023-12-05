import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminProgramas } from '../interfaces/program';
@Injectable({
  providedIn: 'root'
})
export class AdminProgramasService {

  private api = 'http://24.144.89.34:8080/MBA/Chatbot';

  constructor(private http: HttpClient) { }
  getPrograms(): Observable<any>{
    return this.http.get('http://24.144.89.34:8080/MBA/program/getall');
  }
}

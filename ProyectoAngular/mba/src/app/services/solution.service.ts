import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SolucionCasoEstudio } from '../interfaces/solucionCasoEstudio';
import { Observable } from 'rxjs';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class SolutionService {

  private api = 'http://24.144.89.34:8080/MBA/cde';

  constructor(private http: HttpClient) { }

  getSolution(idUsuario: string, idSC: string): Observable<SolucionCasoEstudio>{
    const path = this.api + "/get/solucionUsuario/"+ idUsuario + "/" + idSC
    console.log('URL solicitada:', path);
    console.log(path);
    try{
      const response = this.http.get<SolucionCasoEstudio>(path);
      console.log(response);
      return response;
    } catch (error) {
      console.error('Error en la solicitud:', error);
      throw error;
    }
  }

  getUsers(idSolucion: string){
    const path = this.api + "/usuarios/solucion/" + idSolucion
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

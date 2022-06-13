import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Educacion } from '../model/educacion';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
  private apiServerUrl=environment.apiBaseUrl
  constructor(private http: HttpClient) {  }

  public getEducacion(): Observable<Educacion[]>{
    return this.http.get<Educacion[]>(`${this.apiServerUrl}/educacion/all`);
  }

  public addEducacion(educacion: Educacion): Observable<Educacion>{
    return this.http.post<Educacion>(`${this.apiServerUrl}/educacion/add`,educacion);
  }

  public editarEducacion(educacion: Educacion): Observable<Educacion>{
    return this.http.put<Educacion>(`${this.apiServerUrl}/educacion/update`,educacion);
  }
  public borrarEducacion(educacionId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/educacion/delete/${educacionId}`);
  }
}

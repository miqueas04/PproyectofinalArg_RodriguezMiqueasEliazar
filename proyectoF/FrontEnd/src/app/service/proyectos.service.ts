import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Proyectos } from '../model/proyectos';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {
  private apiServerUrl="https://appmiqueas.herokuapp.com"
  constructor(private http: HttpClient) {  }

  public getProyectos(): Observable<Proyectos[]>{
    return this.http.get<Proyectos[]>(`${this.apiServerUrl}/proyectos/all`);
  }

  public addProyectos(proyectos: Proyectos): Observable<Proyectos>{
    return this.http.post<Proyectos>(`${this.apiServerUrl}/proyectos/add`,proyectos);
  }

  public editarProyectos(proyectos: Proyectos): Observable<Proyectos>{
    return this.http.put<Proyectos>(`${this.apiServerUrl}/proyectos/update`,proyectos);
  }
  public borrarProyectos(proyectosId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/proyectos/delete/${proyectosId}`);
  }
}

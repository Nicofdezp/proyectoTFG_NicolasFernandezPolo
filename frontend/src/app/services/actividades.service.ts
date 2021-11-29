import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Constantes } from '../other/constantes';
import { ActividadModel } from '../other/interfaces';

@Injectable({
  providedIn: 'root'
})
export class ActividadesService {

  listadoActividades: any

  constructor(
    private _constantes: Constantes,
    private _http: HttpClient
  ) { }

  retrieveActividades() {
    this._http.get<Array<ActividadModel>>(`${this._constantes.url_base}/actividad/actividades`).subscribe(response => this.listadoActividades = response)
  }
}

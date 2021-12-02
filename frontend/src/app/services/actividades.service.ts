import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Constantes } from '../other/constantes';
import { ActividadModel, MaterialModel } from '../other/interfaces';

@Injectable({
  providedIn: 'root'
})
export class ActividadesService {

  listadoActividades : any
  listadoMateriales_proporcionados : any
  listadoMateriales_necesarios: any
  activdadSelected !: ActividadModel

  constructor(
    private _constantes: Constantes,
    private _http: HttpClient
  ) { }

  retrieveActividades() {
    this._http.get<Array<ActividadModel>>(`${this._constantes.url_base}/actividad/actividades`).subscribe(response => {
      if(response.length === 0) {
        this.listadoActividades = null
      }else {
        this.listadoActividades = response
      }      
    })
  }

  retrieveMaterialesProporcionados() {
    this._http.get<Array<MaterialModel>>(`${this._constantes.url_base}/actividad/${this.activdadSelected.id}/material_proporcionado`).subscribe(response => {
      if(response.length === 0) {
        this.listadoMateriales_proporcionados = null
      }else {
        this.listadoMateriales_proporcionados = response
      }      
    })
  }

  retrieveMaterialesNecesarios() {
    this._http.get<Array<MaterialModel>>(`${this._constantes.url_base}/actividad/${this.activdadSelected.id}/material_necesario`).subscribe(response => {
      if(response.length === 0) {
        this.listadoMateriales_necesarios = null
      }else {
        this.listadoMateriales_necesarios = response
      }
    })
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Constantes } from '../other/constantes';
import { ActividadModel, TipoReserva } from '../other/interfaces';
import { ActividadesService } from './actividades.service';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  reservaAct: any
  numerogentefinal: any
  numeromonitores: any
  numerogentereserva: any

  reservaSelected: any

  listadoReservasUsuario: any;

  constructor(
    private _activity: ActividadesService,
    private _user: UserService,
    private _http: HttpClient,
    private _constantes: Constantes
  ) { }

  retrieveReservaAct() {
    this._http.get(`${this._constantes.url_base}/reserva/conseguirReserva/${this._activity.activdadSelected.id}`).subscribe(response => {
      this.reservaAct = response;
      this.numerogentefinal = this.reservaAct.personas_finales.length
      this.numerogentereserva = this.reservaAct.personas_reserva.length
      this.numeromonitores = this.reservaAct.personas_monitor.length
    })
  }

  realizarReserva() {
    let body: any 
    this._http.put(`${this._constantes.url_base}/reserva/realizarReserva/${this._activity.activdadSelected.id}/${this._user.user.id}`, body).subscribe();
  }

  retrieveReservaUser() {
    
    this._http.get<Array<TipoReserva>>(`${this._constantes.url_base}/reserva/conseguirReservas/${this._user.user.id}`).subscribe(response => {
      if(response.length === 0) {
        this.listadoReservasUsuario = null
      }else {
        this.listadoReservasUsuario = response
      }
            
    })
  }

  realizarPago() {
    
    let body: any
    
    this._http.put(`${this._constantes.url_base}/reserva/realizarPago/${this.reservaSelected.id_actividad}/${this._user.user.id}`,body).subscribe(response => {
      this.retrieveReservaUser()
    })

  }
}

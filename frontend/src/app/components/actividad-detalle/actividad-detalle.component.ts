import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActividadesService } from 'src/app/services/actividades.service';
import { ReservaService } from 'src/app/services/reserva.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-actividad-detalle',
  templateUrl: './actividad-detalle.component.html',
  styleUrls: ['./actividad-detalle.component.css']
})
export class ActividadDetalleComponent implements OnInit {

  cols !: any[]
  constructor(
    public _activity: ActividadesService,
    public _user: UserService,
    public _reserva: ReservaService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this._activity.retrieveMaterialesProporcionados()
    this._activity.retrieveMaterialesNecesarios()
    this._reserva.retrieveReservaAct()
    this.cols = [
      {field: "nombre_material", header: "Nombre del Material"},  
    ]
  }

  hacerReserva() {
    console.log(this._activity.activdadSelected.id);
    console.log(this._user.user.id);
    
    this._reserva.realizarReserva()
  }

  cancelar() {
    this.router.navigate(["actividades"])
  }

}

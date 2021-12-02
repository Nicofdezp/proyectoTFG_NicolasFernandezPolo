import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReservaService } from 'src/app/services/reserva.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-reservas',
  templateUrl: './reservas.component.html',
  styleUrls: ['./reservas.component.css']
})
export class ReservasComponent implements OnInit {


  cols!: any[];

  reservaSelected: any

  constructor(
    public _reserva: ReservaService,
    public _user: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this._reserva.retrieveReservaUser()

    this.cols = [
      {field: "nombre_actividad", header: "Nombre Actividad"},
      {field: "estado_reserva", header: "Estado de la Reserva"},
    ]

    
    
  }

  pagoCheck() :boolean {
    let pagocheck :boolean = false;    

    if(this.reservaSelected === undefined || this.reservaSelected === null){
      this._reserva.reservaSelected = null;

    }else {
      if(this.reservaSelected.estado_reserva === "pagado") {
        pagocheck = false;
        this._reserva.reservaSelected = this.reservaSelected;
      }else if(this.reservaSelected.estado_reserva === "sin pagar") {
        pagocheck = true;
        this._reserva.reservaSelected = this.reservaSelected;
      }
      
    }
    return pagocheck;
  }

}

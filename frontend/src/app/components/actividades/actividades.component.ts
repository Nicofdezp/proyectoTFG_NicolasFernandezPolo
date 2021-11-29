import { Component, OnInit } from '@angular/core';
import { ActividadModel } from 'src/app/other/interfaces';
import { ActividadesService } from 'src/app/services/actividades.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-actividades',
  templateUrl: './actividades.component.html',
  styleUrls: ['./actividades.component.css']
})
export class ActividadesComponent implements OnInit {

  cols!: any[];

  actividadSelected !: ActividadModel;
  
  constructor(
    private _user : UserService,
    public _activity : ActividadesService
  ) { }

  ngOnInit(): void {

    this.cols = [
      {field: "nombre_actividad", header: "Nombre_Actividad"},
      {field: "tipo_actividad", header: "Tipo de Activdad"},
      {field: "dificultad", header: "Dificultad"},
      {field: "fecha_inicio", header: "Fecha Inicio"},
      {field: "fecha_final", header: "Fecha Fin"},
      {field: "precio", header: "Precio"},
    ]
    
  }


  selectActivity(actividad: ActividadModel) {
    console.log(actividad);
    
  }
}

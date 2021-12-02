import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
    public _activity : ActividadesService,
    public _user : UserService,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.cols = [
      {field: "nombre_actividad", header: "Nombre Actividad"},
      {field: "tipo_actividad", header: "Tipo de Activdad"},
      {field: "dificultad", header: "Dificultad"},
      {field: "fecha_inicio", header: "Fecha Inicio"},
      {field: "fecha_final", header: "Fecha Fin"},
      {field: "precio", header: "Precio"},
    ]
    
  }


  selectActivity() {
    this._activity.activdadSelected = this.actividadSelected;
    this.router.navigate(['actividades', 'actividad']);
  }

  cancelar() {
    this.router.navigate([''])
  }
}

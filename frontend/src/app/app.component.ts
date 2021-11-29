import { Component, OnInit } from '@angular/core';
import { ActividadModel } from './other/interfaces';
import { ActividadesService } from './services/actividades.service';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  

  constructor(
    public _user: UserService,
    public _activity: ActividadesService
  ) {}
  
  ngOnInit(): void {
    this._user.retrieve_user();
    this._activity.retrieveActividades(); 
  }

  title = 'frontend';
}

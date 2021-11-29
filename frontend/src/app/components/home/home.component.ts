import { Component, OnInit } from '@angular/core';
import { Constantes } from 'src/app/other/constantes';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  nombre: String = this._constantes.url_base;
  constructor(
    private _constantes: Constantes,
    public _user: UserService
  ) { }

  ngOnInit(): void {
  }

  hola() {
    console.log(this.nombre)
  }

}

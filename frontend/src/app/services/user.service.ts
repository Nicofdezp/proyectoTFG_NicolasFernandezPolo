import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { Constantes } from '../other/constantes';
import { UsuarioModel } from '../other/interfaces';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  user!: UsuarioModel;
  localStorage: Storage = window.localStorage;


  constructor(
    private router: Router,
    private _constantes: Constantes,
    private _http: HttpClient,
  ) { 
  }
 
  retrieve_user() {
    let id = this.localStorage.getItem('user');

    this._http.get<UsuarioModel>(`${this._constantes.url_base}/usuario/id/${id}`).subscribe(response => {
      this.user = response
    })
  }

  change_datos(datos:any) {
    let id = this.user.id

    this._http.put<UsuarioModel>(`${this._constantes.url_base}/usuario/datos/${id}`,datos).subscribe(response => {
      this.retrieve_user()
    })
  }

  change_password(password: String) {
    let id = this.user.id;
    
    this._http.put<UsuarioModel>(`${this._constantes.url_base}/usuario/contra/${id}`, {
      password : password
    }).subscribe(response => {
      this.retrieve_user()
    })
  }

  change_creditCard(numero_tarjeta: String) {
    let id_usuario = this.user.id;

    let body: any = {
      id_usuario : id_usuario,
      numero_tarjeta: numero_tarjeta,
    }

    this._http.put<UsuarioModel>(`${this._constantes.url_base}/usuario/${id_usuario}/${numero_tarjeta}`, body).subscribe(response => {
      this.retrieve_user()
    })
  }

  logout_user() {
    localStorage.removeItem('user');
    this.router.navigate(['']);
  }

  registrarUsuario(datos : any) {
    this._http.post<UsuarioModel>(`${this._constantes.url_base}/usuario/registro`,datos).subscribe(response => {
      console.log(response)
    })
  }
}

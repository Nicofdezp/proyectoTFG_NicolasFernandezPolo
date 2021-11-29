import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-usuario-info',
  templateUrl: './usuario-info.component.html',
  styleUrls: ['./usuario-info.component.css']
})
export class UsuarioInfoComponent implements OnInit {


  listaGeneros: String[] = ["Masculino","Femenino","No especifica"];

  modificar_usuario: boolean = false;
  modificar_contra: boolean = false;
  modificar_tarjeta: boolean = false;

  //variables para modificar los datos
  new_user_name !: String;
  new_email !: String;
  new_user_fullname !: String;
  new_user_fecha !: Date;
  new_genero !: String;

  //variables para modificar la contraseña
  new_password !: String;
  new_repeat_password !: String;
  contra_coincide: boolean = true;

  //variables para la tarjeta de credito
  new_bankCard !: String;

  constructor(
    public _user: UserService
  ) { }

  ngOnInit(): void {
  }


  toggle_modificarDatos() {

    if(this.modificar_usuario) {
      this.modificar_usuario = false;
    }else {      
      this.modificar_usuario = true;
    }

  }

  toggle_modificarContra() {

    this.new_password = "";
    this.new_repeat_password = "";

    if(this.modificar_contra) {
      this.modificar_contra = false;
    }else {
      this.modificar_contra = true;
    }
  }

  toggle_modificarTarjeta() {
    if(this.modificar_tarjeta) {
      this.modificar_tarjeta = false;
    }else {
      this.modificar_tarjeta = true;
    }
  }

  modificarDatos() {
    let nombre_usuario: String;
    let email: String;
    let nombre_completo: String;
    let fecha_nacimiento: Date;

    if(this.new_user_name === undefined || this.new_user_name.length === 0) {
      nombre_usuario = this._user.user.nombre_usuario
    }else {
      nombre_usuario = this.new_user_name
    }

    if(this.new_email === undefined || this.new_email.length === 0) {
      email = this._user.user.email
    }else {
      email = this.new_email
    }

    if(this.new_user_fullname === undefined || this.new_user_fullname.length === 0) {
      nombre_completo = this._user.user.nombre_completo
    }else {
      nombre_completo = this.new_user_fullname
    }

    if(this.new_user_fecha === undefined || this.new_user_fecha === null|| this.new_user_fecha.toLocaleString().length === 0) {
      fecha_nacimiento = this._user.user.fecha_nacimiento
    }else {
      fecha_nacimiento = this.new_user_fecha
    }
    
    let datos: any = {
      nombre_usuario : nombre_usuario,
      email: email,
      nombre_completo: nombre_completo,
      fecha_nacimiento: fecha_nacimiento.toLocaleString()
    }

    this._user.change_datos(datos);
    this.toggle_modificarDatos();
  }

  modificarContra() {

    if(this.compro_contra()) {
      this._user.change_password(this.new_password)
      this.toggle_modificarContra()
    }
  }

  compro_contra(): boolean {
    if(this.new_password === this.new_repeat_password) {
      this.contra_coincide = true;
    }else {
      this.contra_coincide = false;
    }

    return this.contra_coincide;
  }

  modificarTarjeta() {
    this._user.change_creditCard(this.new_bankCard)
    this.toggle_modificarTarjeta()
  }

}

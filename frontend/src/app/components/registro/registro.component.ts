import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioModel } from 'src/app/other/interfaces';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  user_name !: string;
  user_mail !: string;
  user_complete_name !: string;
  user_fecha !: String;
  password !: string;
  repeat_password !: string;

  contraCorrecta : boolean = true;

  constructor(
    private _user: UserService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }


  registrarse() : void{

    if(this.repeat_password === this.password) {
      this.contraCorrecta = true;
      let datos: any = {
        nombre_usuario : this.user_name,
        email: this.user_mail,
        password: this.password,
        nombre_completo: this.user_complete_name,
        fecha_nacimiento: this.user_fecha,
        trabajador: false,
      }
  
      this._user.registrarUsuario(datos);
    }else {
      this.contraCorrecta = false;
    }
  }

  cancelar() {
    this.router.navigate([''])
  }

}

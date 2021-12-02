import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-crear-trabajor',
  templateUrl: './crear-trabajor.component.html',
  styleUrls: ['./crear-trabajor.component.css']
})
export class CrearTrabajorComponent implements OnInit {

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
        trabajador: true,
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

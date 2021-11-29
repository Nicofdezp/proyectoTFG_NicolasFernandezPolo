import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user_name !: string;
  password !: string;

  constructor(
    public _user: UserService,
    public _login: LoginService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  loguear() {
    if(this.user_name == null || this.user_name.length == 0) {
      
      //TODO mostrar que el nombre de usuario no esta completado
      console.log("El nombre de usuario esta vacio");
      
    }

    if(this.password == null || this.password.length == 0) {

      //TODO mostrar que contraseña no esta completada
      console.log("La contraseña esta vacia")

    }

    if(this.user_name != null && this.password != null && this.user_name.length != 0 && this.password.length != 0) {

      console.log(this.user_name);
      console.log(this.password);
      
      

      this._login.login(this.user_name, this.password).subscribe(response => {
        if(response.success) {
          this._user.user = response.user;
          console.log(this._user.user);
          localStorage.setItem('user', this._user.user.id.valueOf())
          this.router.navigate(['']);
        }
      })
    }
  }
}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit {

  user_name !: string;
  user_mail !: string;
  user_complete_name !: string;
  user_fecha !: Date;
  password !: string;

  constructor() { }

  ngOnInit(): void {
  }


  registrarse() : void{
    console.log(this.user_fecha)
  }

}

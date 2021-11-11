import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user_name !: string;
  password !: string;

  constructor() { }

  ngOnInit(): void {
  }

  loguear() {
    console.log(this.user_name);
    console.log(this.password);
  }
}

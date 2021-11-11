import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  nombre: string = "HOLA QUE TAL";
  constructor() { }

  ngOnInit(): void {
  }

  hola() {
    console.log(this.nombre + " roberto chupapolla")
  }

}

import { Component, OnInit } from '@angular/core';
import 'boxicons';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    
  }

  menuDesplegable(e: any) {
    let arrowParent = e.target.parentElement.parentElement;
    arrowParent.classList.toggle("showMenu");
  }

  openSidebar(){
    let sidebar = document.querySelectorAll(".sidebar");
    sidebar[0].classList.toggle("close");
  }

}

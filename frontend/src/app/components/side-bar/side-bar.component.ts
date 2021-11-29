import { Component, OnInit } from '@angular/core';
import 'boxicons';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {

  constructor(
    public _user: UserService,
    
  ) { }

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

  logout() {
    this._user.logout_user();
    console.log(this._user.user);

    console.log(localStorage.getItem('user'));
    
    
  }

}

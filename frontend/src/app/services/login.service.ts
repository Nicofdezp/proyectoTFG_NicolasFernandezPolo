import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Constantes } from '../other/constantes';
import { LoginResponse } from '../other/interfaces';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    private _constantes: Constantes,
    private _http: HttpClient,
  ) { }


  login(user_name: String, password: String): Observable<LoginResponse> {
    return this._http.post<LoginResponse>(`${this._constantes.url_base}/usuario/auth_login` , {
      user_name: user_name,
      password: password
    })
  }

}

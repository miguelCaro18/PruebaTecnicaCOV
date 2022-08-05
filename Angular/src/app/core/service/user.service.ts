import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable, Subscription, throwError} from 'rxjs';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {environment} from 'src/environments/environment';
import {Usuario, UsuarioSend} from "../../shared/models/data.model";

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private readonly API_URL = environment.apiUrl;


  constructor(private _http: HttpClient) {
  }
  public getAllUsers():Observable<any>{
    return this._http.get<any>(this.API_URL)
  }


  public saveUser(usuarioSend:UsuarioSend):Observable<Usuario>{
    console.log("Guardar");
    console.log(usuarioSend);
    console.log("LINEA 24 de user.service");
    const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this._http.post<Usuario>(this.API_URL , JSON.stringify(usuarioSend),{headers: headers});
  }
}

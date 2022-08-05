import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {UserService} from "../../core/service/user.service";
import {UsuarioSend} from "../../shared/models/data.model";

@Component({
  selector: 'app-detalles',
  templateUrl: './detalles.component.html',
  styleUrls: ['./detalles.component.css']
})
export class DetallesComponent implements OnInit {
  submitted: false;
  // @ts-ignore
  user:UsuarioSend;
  existId: boolean;

  errorMostrar:string;

  constructor(private _userService:UserService) {
    this.submitted=false;
    this.existId=false;
    this.user ={} as UsuarioSend;
    this.user.apellido="Apellidos";
    this.user.identificacion="Identificación";
    this.user.nombre="Nombres";
    this.user.telefono="Telefono";
    this.errorMostrar="";
  }

  ngOnInit(): void {
  }

  guardarUsuario() {
    console.log(this.user)
    console.log("INFO DE TODO ")

    this._userService.saveUser(this.user).subscribe((response)=>{
      console.log("hola todo bien");
      console.log(response);
      window.location.reload();
    },(error)=>{
      console.log("hola error ")
      console.log(error.error.mensaje);
      this.errorMostrar=error.error.mensaje;
      this.existId=true;
    })
  }

  newTutorial() {

  }
}

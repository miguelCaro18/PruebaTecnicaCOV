import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatTableModule } from '@angular/material/table'
import { AppComponent } from './app.component';
import {HeaderComponent} from "./header/header.component";
import { UsuariosComponent } from './usuarios/usuarios.component';
import { ListaComponent } from './usuarios/lista/lista.component';
import { DetallesComponent } from './usuarios/detalles/detalles.component';
import {FormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatPaginatorModule} from "@angular/material/paginator";
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { environment } from '../environments/environment';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    UsuariosComponent,
    ListaComponent,
    DetallesComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

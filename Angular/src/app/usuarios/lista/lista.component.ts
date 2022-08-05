import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {UserService} from "../../core/service/user.service";
import { Observable } from 'rxjs';
import {Usuario} from "../../shared/models/data.model";


@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nombre', 'apellido', 'telefono'];
  dataSource:MatTableDataSource<Usuario> = new MatTableDataSource<Usuario>;
  // @ts-ignore
  @ViewChild(MatPaginator) paginator: MatPaginator;
  constructor(private _userService:UserService) {

  }


  ngAfterViewInit() {
    // @ts-ignore
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {
    this.getAllEntity();
  }
  public getAllEntity(){
    this._userService.getAllUsers().subscribe((response)=>{
      console.log("hola todo bien");
      console.log(response);
      this.dataSource.data=response;
      console.log(this.dataSource.data)
    },(error)=>{
      console.log("hola error ")
    })
  }
}



import { Injectable } from '@angular/core';

// importar  httclient
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient){}

  getUsers(){
    // funcion para traer el listado de usuarios
    return this.http.get<any[]>('users.json');
  }
}

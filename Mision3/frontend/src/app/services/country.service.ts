// Importa el cliente HTTP de Angular.
// Esta clase permite hacer peticiones HTTP como GET, POST, PUT, DELETE a un backend.
import { HttpClient } from '@angular/common/http';

// Importa el decorador Injectable.
// Sirve para decirle a Angular que esta clase puede ser inyectada como dependencia.
import { Injectable } from '@angular/core';

// Importa Observable desde RxJS.
// Angular usa Observables para manejar respuestas asincrónicas de HTTP.
import { Observable } from 'rxjs';

// Importa el modelo Country.
// Este modelo define la estructura de los datos que representan un país.
import { Country } from '../models/country';

// Decorador que marca esta clase como un servicio inyectable en Angular.
@Injectable({

  // providedIn: 'root' significa que Angular creará UNA sola instancia
  // del servicio para toda la aplicación (Singleton).
  providedIn: 'root'
})

// Definición del servicio CountryService.
// Los servicios se usan para manejar lógica de negocio o comunicación con APIs.
export class CountryService {

   // Variable privada que guarda la URL base de la API backend.
  // En este caso apunta a un backend que corre en localhost puerto 8080.
  private apiUrl = "http://localhost:8080/api/country";



  // Constructor del servicio.
  // Angular inyecta automáticamente HttpClient aquí gracias al sistema de
  // Dependency Injection.
  constructor(private http: HttpClient) { }


    // Método que obtiene todos los países desde el backend.
  // Retorna un Observable que emitirá un arreglo de Country.
  getCountries():Observable<Country[]>{
       // Se hace una petición HTTP GET a la URL de la API.
    // <Country[]> indica a TypeScript que la respuesta será un arreglo de Country
    return this.http.get<Country[]>(this.apiUrl);
  }

  // Método que envía un nuevo país al backend para crearlo.
  // Recibe como parámetro un objeto de tipo Country.
  createCountry(country:Country): Observable<Country>{
    // Se hace una petición HTTP POST.
    // Primer parámetro: la URL de la API
    // Segundo parámetro: el objeto que se enviará al servidor
    // <Country> indica que el backend devolverá un Country creado.
    return this.http.post<Country>(this.apiUrl,country);
  }
}

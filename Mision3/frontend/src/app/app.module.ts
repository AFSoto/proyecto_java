
// Importa el decorador NgModule.
// Este decorador le dice a Angular que esta clase es un módulo.
import { NgModule } from '@angular/core';

// Importa BrowserModule.
// Este módulo es necesario para que Angular pueda ejecutarse en el navegador.
import { BrowserModule } from '@angular/platform-browser';

// Importa HttpClientModule.
// Permite usar HttpClient para hacer peticiones HTTP a APIs.
import { HttpClientModule } from '@angular/common/http';


// Importa FormsModule.
// Sirve para trabajar con formularios en Angular (ngModel, inputs, etc).
import {FormsModule} from '@angular/forms';

// Importa el módulo de rutas de la aplicación.
import { AppRoutingModule } from './app-routing.module';


// Importa el componente raíz de la aplicación.
import { AppComponent } from './app.component';

// Importa el componente que maneja países.
import { CountryComponent } from './components/country/country.component';
import { RegionComponent } from './components/region/region.component';

// Decorador que define la configuración del módulo
 @NgModule({

  // DECLARATIONS
  // Aquí se registran los componentes, directivas y pipes
  // que pertenecen a este módulo.
  declarations: [
    AppComponent,
    CountryComponent,
    RegionComponent
  ],
  // IMPORTS
  // Aquí se importan otros módulos que este módulo necesita
  // para funcionar.
  imports: [
    BrowserModule,// Permite que Angular funcione en el navegador
    FormsModule,// Permite usar formularios y ngModel
    AppRoutingModule,// Maneja las rutas de la aplicación
    HttpClientModule// Permite hacer peticiones HTTP
  ],
  // PROVIDERS
  // Aquí se registran servicios globales.
  // En tu caso está vacío porque los servicios usan
  // providedIn: 'root'.
  providers: [],
  // BOOTSTRAP
  // Define el componente principal que Angular cargará
  // cuando la aplicación inicie.
  bootstrap: [AppComponent]
})
export class AppModule { }

// Importa el decorador Component y la interfaz OnInit desde Angular.
// Component sirve para definir un componente.
// OnInit es una interfaz que permite ejecutar código cuando el componente se inicializa.
import { Component, OnInit } from '@angular/core';


// Importa el modelo Country.
// Este modelo define la estructura de los datos de un país.
import { Country } from '../../models/country';

// Importa el servicio que se encarga de comunicarse con la API.
import { CountryService } from '../../services/country.service';

// Decorador que define la configuración del componente.
@Component({
    // Selector del componente.
  // Este es el nombre de la etiqueta HTML que representará este componente.
  // Se usa así: <app-country></app-country>
  selector: 'app-country',
  // Ruta del archivo HTML del componente.
  // Aquí está la vista (lo que se muestra en pantalla).
  templateUrl: './country.component.html',
   // Ruta del archivo CSS del componente.
  // Aquí están los estilos del componente.
  styleUrl: './country.component.css'
})

// Definición del componente.
// Implementa OnInit para usar el método ngOnInit.
export class CountryComponent implements OnInit {

   // Arreglo que almacenará los países obtenidos del backend.
  // Inicialmente está vacío.
  countries: Country[] = [];

   // Objeto que representa un nuevo país que se quiere crear.
  // Se inicializa como una instancia vacía del modelo Country.
  newCountry:Country = new Country();

   // Constructor del componente.
  // Angular inyecta automáticamente CountryService gracias
  // al sistema de Dependency Injection.
  constructor(private countryService : CountryService){}

   // Método del ciclo de vida del componente.
  // Se ejecuta automáticamente cuando el componente se carga.
  ngOnInit(): void {
    // Aquí llamamos a la función que carga los países.
      this.loadCountries();
  }

   // Método que obtiene los países desde el servicio.
  loadCountries(){
    // Llama al método getCountries() del servicio.
    // subscribe se usa para recibir los datos del Observable.
    this.countryService.getCountries().subscribe(data =>{
      // Cuando llegan los datos desde la API,
      // se guardan en la variable countries.
      this.countries = data;
    });
  }

  saveCountry(){
    this.countryService.createCountry(this.newCountry).subscribe(data=>{
      this.loadCountries();
      this.newCountry = new Country();
    });
  }

}
